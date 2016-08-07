package ru.sbt.javaschool.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

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
    public static void assign(Object to, Object from) {
        List<Method> listOfMethodsFrom = Arrays.asList(from.getClass().getMethods());
        List<Method> listOfMethodsTo = Arrays.asList(to.getClass().getMethods());
        for (Method methodFrom : listOfMethodsFrom) {
            for (Method methodTo : listOfMethodsFrom) {
                if (checkGetterAndSetter(methodFrom, methodTo)) {
                    try {
                        methodTo.invoke(to, methodFrom.invoke(from));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static boolean checkGetterAndSetter(Method methodFrom, Method methodTo) {
        if (methodFrom.getName().startsWith("get") && methodTo.getName().startsWith("set") &&
                methodFrom.getName().substring(3).equals(methodTo.getName().substring(3)) &&
                methodFrom.getParameterCount() == 0 && methodTo.getParameterCount() == 1 &&
                methodTo.getReturnType() == void.class && isSubClass(methodTo.getParameterTypes()[0], methodFrom.getReturnType())) {
            return true;
        }
        return false;
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

}
