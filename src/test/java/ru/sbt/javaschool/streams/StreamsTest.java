package ru.sbt.javaschool.streams;

import org.junit.Before;
import org.junit.Test;
import ru.sbt.javaschool.relationship.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Никита on 29.08.2016.
 */
public class StreamsTest {

    List<Person> listOfPersons;

    @Before
    public void setUp() throws Exception {
        listOfPersons = new ArrayList<>();
        listOfPersons.add(new Person("Jake", true));
        listOfPersons.add(new Person("Anna", false));
        listOfPersons.add(new Person("Ken", true));
        listOfPersons.add(new Person("Don", true));
        listOfPersons.add(new Person("Arina", false));
        listOfPersons.add(new Person("Elena", false));
        listOfPersons.add(new Person("Marina", false));
        listOfPersons.add(new Person("Bob", true));
        listOfPersons.add(new Person("Nikita", true));
    }

    @Test
    public void streamTest() throws Exception {
        Map<String, Person> map = Streams.of(listOfPersons)
                .filter(person -> person.isMan())
                .transform(person -> new Person(person.getName() + " Second name", person.isMan()))
                .toMap(Person::getName, person -> person);

        map.keySet().forEach(System.out::println);

    }

}