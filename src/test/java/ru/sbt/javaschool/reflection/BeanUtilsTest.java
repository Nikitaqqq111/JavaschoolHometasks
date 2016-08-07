package ru.sbt.javaschool.reflection;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Никита on 07.08.2016.
 */
public class BeanUtilsTest {
    @Test
    public void assign() throws Exception {

    }

    @Test
    public void checkGetterAndSetter() throws Exception {
    }

    @Test
    public void isSubClass() throws Exception {
        assertTrue(BeanUtils.isSubClass(Number.class, Integer.class));
        assertFalse(BeanUtils.isSubClass(Integer.class, Number.class));
        assertTrue(BeanUtils.isSubClass(Object.class, this.getClass()));
        assertTrue(BeanUtils.isSubClass(String.class, String.class));
    }

}