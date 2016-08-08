package ru.sbt.javaschool.reflection.domain;

import ru.sbt.javaschool.relationship.Person;

/**
 * Created by Никита on 07.08.2016.
 */
public class ObjectFrom {
    private String name;
    private Integer number;
    private boolean trueOrFalse;
    private Person person;

    public ObjectFrom(String name, Integer number, boolean trueOrFalse, Person person) {
        this.name = name;
        this.number = number;
        this.trueOrFalse = trueOrFalse;
        this.person = person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public boolean isTrueOrFalse() {
        return trueOrFalse;
    }

    public void setTrueOrFalse(boolean trueOrFalse) {
        this.trueOrFalse = trueOrFalse;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
