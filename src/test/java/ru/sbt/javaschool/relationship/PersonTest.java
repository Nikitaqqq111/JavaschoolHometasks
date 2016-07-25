package ru.sbt.javaschool.relationship;

import static org.junit.Assert.*;

/**
 * Created by Никита on 25.07.2016.
 */
public class PersonTest {
    Person alex;
    Person ted;
    Person sofia;
    Person sandy;

    @org.junit.Before
    public void setUp() throws Exception {
        alex = new Person("Alex", true);
        ted = new Person("Ted", true);
        sofia = new Person("Sofia", false);
        sandy = new Person("Sandy", false);
    }

    @org.junit.Test
    public void divorce() throws Exception {
        assertFalse(ted.divorce());
        assertTrue(ted.marry(sofia));
        assertTrue(ted.divorce());
        assertNull(ted.getSpouse());
        assertNull(sofia.getSpouse());
        assertFalse(ted.divorce());
        assertFalse(sofia.divorce());
    }

    @org.junit.Test
    public void marry() throws Exception {
        assertFalse(alex.marry(ted));
        assertFalse(ted.marry(alex));
        assertNull(alex.getSpouse());
        assertNull(ted.getSpouse());
        assertTrue(alex.marry(sofia));
        assertEquals(sofia, alex.getSpouse());
        assertEquals(alex, sofia.getSpouse());
        assertTrue(alex.marry(sandy));
        assertEquals(sandy, alex.getSpouse());
        assertEquals(alex, sandy.getSpouse());
        assertNull(sofia.getSpouse());
    }
}