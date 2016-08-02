package ru.sbt.javaschool.generics;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Никита on 31.07.2016.
 */
public class CountMapImpl<K> implements CountMap<K> {

    private final HashMap<K, Integer> countMap = new HashMap<>();

    /**
     * Добавляет элемент в этот контейнер
     */
    public void add(K key) {
        if (countMap.containsKey(key)) {
            countMap.put(key, countMap.get(key) + 1);
        } else {
            countMap.put(key, 1);
        }
    }

    /**
     * Возвращает количество добавлений данного элемента
     *
     * @return количество добавлений данного элемента
     */
    public int getCount(K key) {
        if (countMap.containsKey(key)) {
            return countMap.get(key);
        }
        return 0;
    }

    /**
     * Удаляет элемент из контейнера и возвращает количество его добавлений (до удаления)
     *
     * @return количество добавлений данного элемента до удаления
     */
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

    /**
     * Возвращает количество разных элементов
     *
     * @return количество разных элементов
     */
    public int size() {
        return countMap.size();
    }

    /**
     * Добавить все элементы из source в текущий контейнер, при совпадении ключей суммировать значения
     */
    public void addAll(CountMap<? extends K> sourceCountMap) {
        Map<? extends K, Integer> sourceMap = sourceCountMap.toMap();
        for (K keyOfSourceMap : sourceMap.keySet()) {
            if (countMap.containsKey(keyOfSourceMap)) {
                countMap.put(keyOfSourceMap, countMap.get(keyOfSourceMap) + sourceMap.get(keyOfSourceMap));
            } else {
                countMap.put(keyOfSourceMap, sourceMap.get(keyOfSourceMap));
            }
        }
    }

    /**
     * Вернуть java.util.Map. Ключ - добавленный элемент, значение - количество его добавлений
     *
     * @return Map
     */
    public Map<K, Integer> toMap() {
        return countMap;
    }

    /**
     * Тот же самый контракт как и toMap(), только всю информацию записать в destination
     */
    public void toMap(Map<? super K, Integer> destinationMap) {
        destinationMap.clear();
        destinationMap.putAll(countMap);
    }

}
