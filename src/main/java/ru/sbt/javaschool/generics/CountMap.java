package ru.sbt.javaschool.generics;

import java.util.Map;

/**
 * Created by Никита on 31.07.2016.
 */

public interface CountMap<K extends Comparable<K>>{
        // добавляет элемент в этот контейнер.
        void add(K o);

        //Возвращает количество добавлений данного элемента
        int getCount(K o);

        //Удаляет элемент и контейнера и возвращает количество его добавлений(до удаления)
        int remove(K o);

        //количество разных элементов
        int size();

        //Добавить все элементы из source в текущий контейнер, при совпадении ключей, суммировать значения
        void addAll(CountMap<K> sourceCountMap);

        //Вернуть java.util.Map. ключ - добавленный элемент, значение - количество его добавлений
        Map<K, Integer> toMap();

        //Тот же самый контракт как и toMap(), только всю информацию записать в destination
        void toMap(Map<K, Integer> destination);
        }

