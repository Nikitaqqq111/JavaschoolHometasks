package ru.sbt.javaschool.sockets.serialization;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Никита on 09.09.2016.
 */
public class SerializationUtils {
    public static List<Object> serialize(Method method, Object[] args) {
        List<Object> result = new ArrayList<>();
        result.add(method.getName());
        result.addAll(Arrays.asList(args));
        return result;
    }
}
