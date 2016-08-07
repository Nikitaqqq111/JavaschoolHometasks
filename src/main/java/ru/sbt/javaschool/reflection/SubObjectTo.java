package ru.sbt.javaschool.reflection;

/**
 * Created by Никита on 07.08.2016.
 */
public class SubObjectTo extends ObjectTo {
    private String name;

    public SubObjectTo(String name, Number number, boolean trueOrFalse, String name1) {
        super(name, number, trueOrFalse);
        this.name = name1;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
