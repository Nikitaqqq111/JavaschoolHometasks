package ru.sbt.javaschool.refactoring.tractor;

/**
 * Created by Никита on 16.09.2016.
 */
public class DeltaStep {
    private final int deltaPointX;
    private final int deltaPointY;

    public DeltaStep(int deltaPointX, int deltaPointY) {
        this.deltaPointX = deltaPointX;
        this.deltaPointY = deltaPointY;
    }

    public int getDeltaPointX() {
        return deltaPointX;
    }

    public int getDeltaPointY() {
        return deltaPointY;
    }
}
