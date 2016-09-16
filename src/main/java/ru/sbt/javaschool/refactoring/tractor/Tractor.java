package ru.sbt.javaschool.refactoring.tractor;

import static ru.sbt.javaschool.refactoring.tractor.Command.FORWARD;
import static ru.sbt.javaschool.refactoring.tractor.Orientation.*;

/**
 * Created by Никита on 16.09.2016.
 */
public class Tractor {
    private Position currentTractorPosition = new Position(0, 0);
    private final Position field = new Position(5, 5);
    private Orientation orientation = NORTH;

    public void move(Command command) {
        if (command == FORWARD) {
            moveForwards();
            return;
        }
        turnClockwise();
    }

    public void moveForwards() {
        currentTractorPosition = currentTractorPosition.move(orientation);
        currentTractorPosition.checkDitch(field);
    }

    public void turnClockwise() {
        orientation = OrientationUtils.switchOrientation(orientation);
    }

    public int getPositionX() {
        return currentTractorPosition.getPointX();
    }

    public int getPositionY() {
        return currentTractorPosition.getPointY();
    }

    public Orientation getOrientation() {
        return orientation;
    }
}
