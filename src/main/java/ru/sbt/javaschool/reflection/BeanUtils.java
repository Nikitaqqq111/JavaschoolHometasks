package ru.sbt.javaschool.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Никита on 07.08.2016.
 */
public class BeanUtils {
    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */
    private static boolean isGetter(Method method) {
        return method.getName().startsWith("get") && method.getParameterCount() == 0 && !void.class.equals(method.getReturnType());
    }

    private static boolean isSetter(Method method) {
        return method.getName().startsWith("set") && method.getParameterCount() == 1;
    }

    public static boolean isSubClass(Class<?> parent, Class<?> child) {
        while (child != null) {
            if (parent == child) {
                return true;
            }
            child = child.getSuperclass();
        }
        return false;
    }

    public static void assign(Object to, Object from) {
        Map<String, Method> getters = new HashMap<>(), setters = new HashMap<>();
        for (Method method : from.getClass().getMethods()) {
            if (isGetter(method)) {
                if (!getters.containsKey(method.getName().substring(3))) {
                    getters.put(method.getName().substring(3), method);
                } else {
                    try {
                        throw new TooManyGettersWithDuplicatesNamesException();
                    } catch (TooManyGettersWithDuplicatesNamesException ex) {
                        System.err.println("Warning: Too many getters with duplicates names. The function assign may have a problem!");
                    }
                }
            }
        }
        for (Method method : to.getClass().getMethods()) {
            if (isSetter(method)) {
                if (!setters.containsKey(method.getName().substring(3))) {
                    setters.put(method.getName().substring(3), method);
                } else {
                    try {
                        throw new TooManySettersWithDuplicatesNamesException();
                    } catch (TooManySettersWithDuplicatesNamesException ex) {
                        System.err.println("Warning: Too many setters with duplicates names. The function assign may have a problem!");
                    }
                }
            }
        }
        for (String nameOfField : getters.keySet()) {
            if (setters.containsKey(nameOfField) && isSubClass(setters.get(nameOfField).getParameterTypes()[0], getters.get(nameOfField).getReturnType())) {
                try {
                    setters.get(nameOfField).invoke(to, getters.get(nameOfField).invoke(from));
                } catch (IllegalAccessException | InvocationTargetException ex) {
                    System.err.println("IllegalAccessException or InvocationTargetException");
                }
            }
        }
    }
}
