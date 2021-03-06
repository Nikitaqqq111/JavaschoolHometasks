package ru.sbt.javaschool.sockets;

import ru.sbt.javaschool.sockets.domain.Concatination;

import static java.lang.ClassLoader.getSystemClassLoader;
import static java.lang.reflect.Proxy.newProxyInstance;

/**
 * Created by Никита on 09.09.2016.
 */
public class NetClientFactory {
    private final String host;
    private final int port;

    public NetClientFactory(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public <T> T createClient(Class<T> interfaceClass) {
        return (T) newProxyInstance(getSystemClassLoader(), new Class[]{interfaceClass}, new ClientInvocationHandler(host, port));
    }

    public static void main(String[] args) {
        NetClientFactory factory = new NetClientFactory("localhost", 5000);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                Concatination client = factory.createClient(Concatination.class);
                String concateResult = client.concate(Thread.currentThread().getName(), " ");
                System.out.println(concateResult);
            }).start();
        }
    }
}
