package ru.sbt.javaschool.refactoring.tractor;

import java.util.HashMap;
import java.util.Map;

import static ru.sbt.javaschool.refactoring.tractor.Orientation.*;

/**
 * Created by Никита on 16.09.2016.
 */
public class OrientationUtils {
    private final static Map<Orientation, Orientation> switchMap = new HashMap<>();

    static {
        switchMap.put(NORTH, EAST);
        switchMap.put(EAST, SOUTH);
        switchMap.put(SOUTH, WEST);
        switchMap.put(WEST, NORTH);
    }

    public static Orientation switchOrientation(Orientation orientation) {
        return switchMap.get(orientation);
    }
}
