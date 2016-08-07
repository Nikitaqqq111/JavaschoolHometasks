package ru.sbt.javaschool.reflection;

import org.junit.Test;
import ru.sbt.javaschool.relationship.Person;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Никита on 07.08.2016.
 */
public class BeanUtilsTest {
    @Test
    public void assign() throws Exception {
        ObjectFrom objectFrom = new ObjectFrom("SmthFrom", 12, false, new Person("Jake", true));
        ObjectTo objectTo = new ObjectTo("SmthTo", 10, true);
        SubObjectTo subObjectTo = new SubObjectTo("SmthTo", 10, true, "SmthTo2");
        BeanUtils.assign(objectTo, objectFrom);
        BeanUtils.assign(subObjectTo, objectFrom);
        assertEquals(objectFrom.getName(), objectTo.getName());
        assertEquals(objectFrom.getNumber(), objectTo.getNumber());
        assertEquals(objectFrom.getName(), subObjectTo.getName());
        assertEquals(objectFrom.getName(), ((ObjectTo)subObjectTo).getName());
        BeanUtils.assign(new Integer(0), new Date());
    }
}