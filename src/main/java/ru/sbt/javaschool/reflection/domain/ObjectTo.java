package ru.sbt.javaschool.reflection.domain;

/**
 * Created by Никита on 07.08.2016.
 */
public class ObjectTo {
    private String name;
    private Number number;
    private boolean trueOrFalse;
    private int person = 0;

    public ObjectTo(String name, Number number, boolean trueOrFalse) {
        this.name = name;
        this.number = number;
        this.trueOrFalse = trueOrFalse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public boolean isTrueOrFalse() {
        return trueOrFalse;
    }

    public void setTrueOrFalse(boolean trueOrFalse) {
        this.trueOrFalse = trueOrFalse;
    }
}
