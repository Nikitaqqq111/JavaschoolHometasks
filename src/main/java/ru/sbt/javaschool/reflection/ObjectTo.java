package ru.sbt.javaschool.reflection;

/**
 * Created by Никита on 07.08.2016.
 */
public class ObjectTo {
    private String name;
    private Number number;
    private Integer count;
    private boolean trueOrFalse;

    public ObjectTo(String name, Number number, Integer count, boolean trueOrFalse) {
        this.name = name;
        this.number = number;
        this.count = count;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public boolean isTrueOrFalse() {
        return trueOrFalse;
    }

    public void setTrueOrFalse(boolean trueOrFalse) {
        this.trueOrFalse = trueOrFalse;
    }
}
