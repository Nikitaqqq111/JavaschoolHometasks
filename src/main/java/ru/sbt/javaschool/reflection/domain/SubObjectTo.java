package ru.sbt.javaschool.reflection.domain;

/**
 * Created by Никита on 07.08.2016.
 */
public class SubObjectTo extends ObjectTo {
    private Object name;

    public SubObjectTo(String name, Number number, boolean trueOrFalse, Object name1) {
        super(name, number, trueOrFalse);
        this.name = name1;
    }

    public void setName(Object name) {
        this.name = name;
    }
}
