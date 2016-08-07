package ru.sbt.javaschool.reflection;

import org.junit.Test;
import ru.sbt.javaschool.relationship.Person;

import static org.junit.Assert.*;

/**
 * Created by Никита on 07.08.2016.
 */
public class BeanUtilsTest {
    @Test
    public void assign() throws Exception {
        ObjectFrom objectFrom = new ObjectFrom("SmthFrom", 12, false, new Person("Jake", true));
        ObjectTo objectTo = new ObjectTo("SmthTo", 10, true);
        BeanUtils.assign(objectTo, objectFrom);
        assertEquals(objectFrom.getName(), objectTo.getName());
        assertEquals(objectFrom.getNumber(), objectTo.getNumber());
    }

    @Test
    public void isSubClass() throws Exception {
        assertTrue(BeanUtils.isSubClass(Number.class, Integer.class));
        assertFalse(BeanUtils.isSubClass(Integer.class, Number.class));
        assertTrue(BeanUtils.isSubClass(Object.class, this.getClass()));
        assertTrue(BeanUtils.isSubClass(String.class, String.class));
    }

}