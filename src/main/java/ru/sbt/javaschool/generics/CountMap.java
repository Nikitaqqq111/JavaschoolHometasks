package ru.sbt.javaschool.generics;

import java.util.Map;

/**
 * Created by Никита on 31.07.2016.
 */

public interface CountMap<K extends Comparable<K>> {

    void add(K o);

    int getCount(K o);

    int remove(K o);

    int size();

    void addAll(CountMap<K> sourceCountMap);

    Map<K, Integer> toMap();

    void toMap(Map<K, Integer> destination);
}

