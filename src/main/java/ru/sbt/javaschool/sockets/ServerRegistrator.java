package ru.sbt.javaschool.sockets;

import ru.sbt.javaschool.sockets.domain.ConcatinationImpl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Никита on 09.09.2016.
 */
public class ServerRegistrator {

    public static void listen(String host, int port, Object impl) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(port);
        ExecutorService tp = Executors.newFixedThreadPool(3);
        Semaphore semaphore = new Semaphore(3);
        while (true) {
            semaphore.acquire();
            Socket socketClient = serverSocket.accept();
            tp.execute(() -> {
                InvokeUtils.invoke(socketClient, impl, semaphore);
            });
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerRegistrator.listen("localhost", 5000, new ConcatinationImpl());
    }

}
