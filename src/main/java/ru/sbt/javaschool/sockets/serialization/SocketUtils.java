package ru.sbt.javaschool.sockets.serialization;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Никита on 09.09.2016.
 */
public class SocketUtils {
    public static List<Object> serialize(Method method, Object[] args) {
        List<Object> result = new ArrayList<>();
        result.add(method.getName());
        result.addAll(Arrays.asList(args));
        return result;
    }

    public static void checkResult(Object result) {
        if (result instanceof Exception) {
            throw new RuntimeException((Exception) result);
        }
    }

    public static String getMethodName(Object params) {
        return (String) ((List<Object>) params).get(0);
    }

    public static Class<?>[] getClassOfParams(List<Object> params) {
        Object[] args = params.subList(1, params.size()).toArray();
        Class<?>[] argsClazz = new Class<?>[args.length];
        int i = -1;
        for (Object arg : args) {
            argsClazz[++i] = arg.getClass();
        }
        return argsClazz;
    }

    public static Object[] getParams(List<Object> params) {
        return params.subList(1, params.size()).toArray();
    }



}
