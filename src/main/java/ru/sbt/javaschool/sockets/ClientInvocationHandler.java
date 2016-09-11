package ru.sbt.javaschool.sockets;

import ru.sbt.javaschool.sockets.serialization.SocketUtils;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * Created by Никита on 09.09.2016.
 */
public class ClientInvocationHandler implements InvocationHandler {
    private final String host;
    private final int port;

    public ClientInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try (Socket client = new Socket(host, port);
             OutputStream os = client.getOutputStream();
             InputStream is = client.getInputStream();
             ObjectOutputStream oos = new ObjectOutputStream(os);
             ObjectInputStream ois = new ObjectInputStream(is)) {
            oos.writeObject(SocketUtils.serialize(method, args));
            oos.flush();
            result = ois.readObject();
            SocketUtils.checkResult(result);
        }
        return result;
    }

}
