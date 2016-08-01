package ru.sbt.javaschool.generics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Никита on 01.08.2016.
 */
public class CountMapImplTest {

    CountMap<String> countMap;

    Map<String, Integer> map;

    @Before
    public void setUp() throws Exception {
        countMap = new CountMapImpl<>();
        map = new HashMap<>();
    }

    @Test
    public void add() throws Exception {
        countMap.add("Alex");
        countMap.add("Alex");
        countMap.add("Anna");
        countMap.add("Steve");
        countMap.add("Steve");
        countMap.add("Steve");
        assertEquals((Integer) 2, countMap.toMap().get("Alex"));
        assertEquals((Integer) 1, countMap.toMap().get("Anna"));
        assertEquals((Integer) 3, countMap.toMap().get("Steve"));
        assertNull(countMap.toMap().get("Eliza"));
    }

    @Test
    public void getCount() throws Exception {
        countMap.add("Alex");
        countMap.add("Marina");
        countMap.add("Alex");
        countMap.add("Alex");
        countMap.add("Jake");
        countMap.add("Jake");
        countMap.add("Kormen");
        assertEquals(3, countMap.getCount("Alex"));
        assertEquals(2, countMap.getCount("Jake"));
        assertEquals(1, countMap.getCount("Kormen"));
        assertEquals(1, countMap.getCount("Marina"));
        assertEquals(0, countMap.getCount("John"));
    }

    @Test
    public void remove() throws Exception {
        countMap.add("Alex");
        countMap.add("Marina");
        countMap.add("Alex");
        countMap.add("Alex");
        countMap.add("Jake");
        countMap.add("Jake");
        assertEquals(3, countMap.remove("Alex"));
        assertEquals(0, countMap.remove("John"));
        assertEquals(2, countMap.remove("Jake"));
        assertEquals(1, countMap.remove("Jake"));
        assertFalse(countMap.toMap().containsKey("Jake"));
    }

    @Test
    public void size() throws Exception {
        countMap.add("Alex");
        countMap.add("Marina");
        countMap.add("Alex");
        countMap.add("Alex");
        countMap.add("Jake");
        countMap.add("Jake");
        assertEquals(3, countMap.size());
        countMap.remove("Alex");
        countMap.remove("Alex");
        countMap.remove("Alex");
        assertEquals(2, countMap.size());
    }

    @Test
    public void addAll() throws Exception {
        CountMap<Integer> countMapFirst = new CountMapImpl<>();
        CountMap<Integer> countMapSecond = new CountMapImpl<>();
        countMapFirst.add(1);
        countMapFirst.add(3);
        countMapFirst.add(4);
        countMapFirst.add(4);
        countMapSecond.add(1);
        countMapSecond.add(2);
        countMapSecond.add(3);
        countMapSecond.add(3);
        countMapSecond.add(3);
        countMapSecond.add(3);
        countMapSecond.add(5);
        countMapFirst.addAll(countMapSecond);
        assertEquals(1, countMapFirst.getCount(2));
        assertEquals(1, countMapFirst.getCount(5));
        assertEquals(2, countMapFirst.getCount(4));
        assertEquals(2, countMapFirst.getCount(1));
        assertEquals(5, countMapFirst.getCount(3));
        assertEquals(0, countMapFirst.getCount(10));
    }

    @Test
    public void toMap() throws Exception {
        countMap.add("Stefano");
        countMap.add("Stefano");
        countMap.add("Maria");
        countMap.add("Maria");
        countMap.add("Maria");
        countMap.add("Olga");
        map = countMap.toMap();
        assertEquals(3, map.size());
        assertEquals((Integer) 2, map.get("Stefano"));
        assertEquals((Integer) 3, map.get("Maria"));
        assertEquals((Integer) 1, map.get("Olga"));
        assertNull(map.get("Cris"));
    }

    @Test
    public void toMap1() throws Exception {
        countMap.add("Alex");
        countMap.add("Den");
        countMap.add("Sandra");
        countMap.add("Natasha");
        countMap.add("Nikita");
        countMap.add("Alex");
        countMap.add("Nikita");
        map.put("Professor", 1);
        map.put("Teacher", 2);
        map.put("Driver", 3);
        countMap.toMap(map);
        assertTrue(map.containsKey("Sandra"));
        assertTrue(map.containsKey("Den"));
        assertTrue(map.containsKey("Natasha"));
        assertFalse(map.containsKey("Professor"));
        assertFalse(map.containsKey("Teacher"));
        assertFalse(map.containsKey("Driver"));
    }

}