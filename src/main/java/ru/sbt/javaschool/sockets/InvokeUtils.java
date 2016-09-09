package ru.sbt.javaschool.sockets;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Никита on 09.09.2016.
 */
public class InvokeUtils {
    public static void invoke(Socket socketClient, Object impl) {
        try (OutputStream os = socketClient.getOutputStream();
             InputStream is = socketClient.getInputStream();
             ObjectOutputStream oos = new ObjectOutputStream(os);
             ObjectInputStream ois = new ObjectInputStream(is)) {
            System.out.println("Into InvokeUtils");
            List<Object> params = (List<Object>) ois.readObject();
            System.out.println(params);
            String methodName = (String) params.get(0);
            Object[] args = params.subList(1, params.size()).toArray();
            List<Class<?>> argsClazz = new ArrayList<>();
            for (Object arg : args) argsClazz.add(arg.getClass());
            oos.writeObject(impl.getClass().getMethod(methodName, (Class<?>[]) argsClazz.toArray()).invoke(impl, args));
            oos.flush();
            System.out.println("Exit InvokeUtils");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            try (OutputStream os = socketClient.getOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(os)) {
                oos.writeObject(e);
            } catch (IOException e1) {
                throw new RuntimeException(e);
            }
        }
    }
}
