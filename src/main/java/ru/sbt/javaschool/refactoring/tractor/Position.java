package ru.sbt.javaschool.refactoring.tractor;

import java.util.HashMap;
import java.util.Map;

import static ru.sbt.javaschool.refactoring.tractor.Orientation.*;

/**
 * Created by Никита on 16.09.2016.
 */
public class Position {
    private final int pointX;
    private final int pointY;

    private static final Map<Orientation, DeltaStep> steps = new HashMap<>();

    static {
        steps.put(NORTH, new DeltaStep(0, 1));
        steps.put(EAST, new DeltaStep(1, 0));
        steps.put(SOUTH, new DeltaStep(0, -1));
        steps.put(WEST, new DeltaStep(-1, 0));
    }

    public Position(int pointX, int pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    public Position move(Orientation orientation) {
        return new Position(pointX + steps.get(orientation).getDeltaPointX(), pointY + steps.get(orientation).getDeltaPointY());
    }

    public int getPointX() {
        return pointX;
    }

    public int getPointY() {
        return pointY;
    }

    public void checkDitch(Position field) {
        if (pointX > field.getPointX() || pointY > field.getPointY())
            throw new TractorInDitchException("Tractor in Ditch");
    }
}
