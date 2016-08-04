package ru.sbt.javaschool.exceptions.store;

import java.util.List;

/**
 *
 * @author evstafiev
 */
public interface Store {

    void save(String t);

    List<String> getAll();
}
