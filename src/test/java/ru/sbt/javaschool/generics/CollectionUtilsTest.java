package ru.sbt.javaschool.generics;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Никита on 02.08.2016.
 */
public class CollectionUtilsTest {
    List<Integer> integers;
    List<String> strings;

    @Before
    public void setUp() throws Exception {
        integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(5);
        integers.add(3);
        integers.add(1);
        integers.add(2);
        integers.add(321);
        integers.add(13);
        integers.add(14);
        strings = new ArrayList<>();
        strings.add("Jake");
        strings.add("Ava");
        strings.add("Marina");
        strings.add("Mary");
        strings.add("Frank");
        strings.add("Jake");
        strings.add("Jake");
        strings.add("Jason");
        strings.add("Nikita");
        strings.add("Natasha");
    }

    @Test
    public void addAll() throws Exception {
        List<Number> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(5);
        numbers.add(6);
        numbers.add(73);
        numbers.add(255);
        CollectionUtils.addAll(integers, numbers);
        assertTrue(numbers.contains(255));
        assertTrue(numbers.contains(321));
        assertFalse(numbers.contains(-1));
    }

    @Test
    public void newArrayList() throws Exception {
        integers = CollectionUtils.newArrayList();
        assertTrue(integers.add(1));
        assertTrue(integers.add(2));
        assertTrue(integers.add(10));
        assertEquals((Integer) 1, integers.get(0));
        assertEquals((Integer) 2, integers.get(1));
        assertEquals((Integer) 10, integers.get(2));
    }

    @Test
    public void indexOf() throws Exception {
        assertEquals(0, CollectionUtils.indexOf(strings, "Jake"));
        assertEquals(8, CollectionUtils.indexOf(integers, 14));
    }

    @Test
    public void limit() throws Exception {
        List<Integer> integersWithLimit = CollectionUtils.limit(integers, 5);
        assertEquals(5, integersWithLimit.size());
        assertTrue(integersWithLimit.contains(1));
        assertTrue(integersWithLimit.contains(2));
        assertTrue(integersWithLimit.contains(5));
        assertTrue(integersWithLimit.contains(3));
        assertFalse(integersWithLimit.contains(14));
    }


    @Test
    public void add() throws Exception {
        CollectionUtils.add(strings, "Abaragma");
        assertTrue(strings.contains("Abaragma"));
        CollectionUtils.add(integers, 7334);
        assertTrue(integers.contains(7334));
    }

    @Test
    public void removeAll() throws Exception {
        List<Number> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(5);
        numbers.add(6);
        numbers.add(73);
        numbers.add(255);
        integers.removeAll(numbers);
        assertFalse(integers.contains(1));
        assertFalse(integers.contains(3));
        assertFalse(integers.contains(255));
    }

    @Test
    public void containsAll() throws Exception {
        List<Number> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(5);
        assertTrue(CollectionUtils.containsAll(integers, numbers));
    }

    @Test
    public void containsAny() throws Exception {
        integers = new ArrayList<>();
        List<Number> numbers = new ArrayList<>();
        integers.add(1);
        integers.add(3);
        integers.add(5);
        numbers.add(1);
        numbers.add(3);
        assertTrue(CollectionUtils.containsAny(integers, numbers));
        assertTrue(CollectionUtils.containsAny(numbers, integers));
    }

    @Test
    public void range() throws Exception {
        assertEquals(Arrays.asList(3, 5, 6, 4), CollectionUtils.range(Arrays.asList(8, 1, 3, 5, 6, 4), 3, 6));
        assertEquals(Arrays.asList(3l, 5l, 6l, 4l), CollectionUtils.range(Arrays.asList(8l, 1l, 3l, 5l, 6l, 4l), 3l, 6l));
        assertEquals(Arrays.asList("Anna", "Bob", "Ian"), CollectionUtils.range(Arrays.asList("Anna", "Bob", "Jake", "Sam", "Maria", "Ian"), "Anna", "Ian"));
    }

    @Test
    public void range1() throws Exception {
        assertEquals(Arrays.asList(3, 5, 4), CollectionUtils.range(Arrays.asList(8, 1, 3, 5, 6, 4), 3, 5, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.hashCode() -  o2.hashCode();
            }
        }));
    }

}