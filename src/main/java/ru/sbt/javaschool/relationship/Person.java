package ru.sbt.javaschool.relationship;

/**
 * Created by Никита on 24.07.2016.
 */
public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;

    public Person(String name, boolean man) {
        this.name = name;
        this.man = man;
    }

    public String getName() {
        return name;
    }

    public boolean isMan() {
        return man;
    }

    public Person getSpouse() {
        return spouse;
    }

    private void setSpouse(Person spouse) {
        this.spouse = spouse;
    }


    /**
     * Sets spouse = null if spouse is not null
     *
     * @return true - if person status has been changed
     */

    public boolean divorce() {
        if (spouse == null) {
            return false;
        }
        spouse.setSpouse(null);
        spouse = null;
        return true;

    }


    /**
     * This method checks gender of persons. If genders are not equal - tries to marry.
     * <p>
     * If one of them has another spouse - execute divorce(sets spouse = null for husband and wife. Example: if both persons have spouses - then divorce will set 4 spouse to null) and then executes marry().
     *
     * @param person - new husband/wife for this person.
     * @return - returns true if this person has another gender than passed person and they are not husband and wife, false otherwise
     */

    public boolean marry(Person person) {
        if (isMan() == person.isMan()) {
            return false;
        }
        divorce();
        person.divorce();
        setSpouse(person);
        person.setSpouse(this);
        return true;
    }

}
