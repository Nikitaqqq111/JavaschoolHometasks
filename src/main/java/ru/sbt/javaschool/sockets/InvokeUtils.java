package ru.sbt.javaschool.sockets;

import ru.sbt.javaschool.sockets.serialization.SocketUtils;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by Никита on 09.09.2016.
 */
public class InvokeUtils {
    public static void invoke(Socket socketClient, Object impl, Semaphore semaphore) {
        try (Socket socket = socketClient) {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            List<Object> params = (List<Object>) ois.readObject();
            oos.writeObject(impl.getClass().getMethod(SocketUtils.getMethodName(params), SocketUtils.getClassOfParams(params)).invoke(impl, SocketUtils.getParams(params)));
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            try {
                ObjectOutputStream oos = new ObjectOutputStream(socketClient.getOutputStream());
                oos.writeObject(e);
            } catch (IOException e1) {
                throw new RuntimeException(e1);
            }
        } finally {
            semaphore.release();
        }
    }
}
