package ru.sbt.javaschool.sockets;

import ru.sbt.javaschool.sockets.domain.CalculatorImpl;
import ru.sbt.javaschool.sockets.serialization.SerializationUtils;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Никита on 09.09.2016.
 */
public class ServerRegistrator {

    public static void listen(String host, int port, Object impl) throws IOException {

        ServerSocket serverSocket = new ServerSocket(port);

        /*while (true) {*/
            System.out.println("into while");
            try (Socket socketClient = serverSocket.accept()) {
                new Thread(() -> {
                    InvokeUtils.invoke(socketClient, impl);
                }).start();
            }
        /*}*/
    }

    public static void main(String[] args) throws IOException {
        ServerRegistrator.listen("localhost", 5000, new CalculatorImpl());
    }

}
