package ru.sbt.javaschool.generics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Никита on 31.07.2016.
 */
public class CountMapImpl<K extends Comparable<K>> implements CountMap<K> {

    private final HashMap<K, Integer> countMap = new HashMap<>();

    public void add(K key) {
        if (countMap.containsKey(key)) {
            countMap.put(key, countMap.get(key) + 1);
        } else {
            countMap.put(key, 1);
        }
    }

    public int getCount(K key) {
        if (countMap.containsKey(key)) {
            return countMap.get(key);
        }
        return 0;
    }

    public int remove(K key) {
        if (!countMap.containsKey(key)) {
            return 0;
        }

        int prevCount = countMap.get(key);
        if (prevCount == 1) {
            countMap.remove(key);
            return prevCount;
        } else {
            countMap.put(key, prevCount - 1);
            return prevCount;
        }
    }

    public int size() {
        return countMap.size();
    }

    public void addAll(CountMap<K> sourceCountMap) {
        Map<K, Integer> sourceMap = sourceCountMap.toMap();
        for (K keyOfSourceSimpleMap : sourceMap.keySet()) {
            if (countMap.containsKey(keyOfSourceSimpleMap)) {
                countMap.put(keyOfSourceSimpleMap, countMap.get(keyOfSourceSimpleMap) + sourceMap.get(keyOfSourceSimpleMap));
            } else {
                countMap.put(keyOfSourceSimpleMap, sourceMap.get(keyOfSourceSimpleMap));
            }
        }


    }

    public Map<K, Integer> toMap() {
        return countMap;
    }

    public void toMap(Map<K, Integer> destinationMap) {
        destinationMap.clear();
        destinationMap.putAll(countMap);
    }


}
