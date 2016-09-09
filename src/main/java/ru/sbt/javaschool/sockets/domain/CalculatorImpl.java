package ru.sbt.javaschool.sockets.domain;

/**
 * Created by Никита on 09.09.2016.
 */
public class CalculatorImpl implements Calculator {
    @Override
    public double calculate(int a, int b) {
        return a + b - 410 / 12;
    }
}
