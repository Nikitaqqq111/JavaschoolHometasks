package ru.sbt.javaschool.generics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Iterator;

/**
 * Created by Никита on 02.08.2016.
 */
public class CollectionUtils {
    public static <E> void addAll(List<? extends E> source, List<? super E> destination) {
        destination.addAll(source);
    }

    public static <E> List<E> newArrayList() {
        return new ArrayList<>();
    }

    public static <E> int indexOf(List<? extends E> source, E o) {
        return source.indexOf(o);
    }

    public static <E> List<E> limit(List<E> source, int size) {
        return source.subList(0, size);
    }

    public static <E> void add(List<? super E> destination, E o) {
        destination.add(o);
    }

    public static <E> void removeAll(List<? extends E> removeFrom, List<? extends E> c2) {
        removeFrom.removeAll(c2);
    }

    public static <E> boolean containsAll(List<? extends E> c1, List<? extends E> c2) {
        return c1.containsAll(c2);
    }

    public static <E> boolean containsAny(List<? extends E> c1, List<? extends E> c2) {
        Iterator<? extends E> iterator = c2.iterator();
        while (iterator.hasNext()) {
            if (c1.contains(iterator.next())) {
                return true;
            }
        }
        return false;
    }

    public static <E extends Comparable<? super E>> List<E> range(List<? extends E> list, E min, E max) {
        List<E> rangeList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).compareTo(min) >= 0 && list.get(i).compareTo(max) <= 0) {
                rangeList.add(list.get(i));
            }
        }
        return rangeList;
    }

    public static <E> List<E> range(List<? extends E> list, E min, E max, Comparator<? super E> comparator) {
        List<E> rangeList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (comparator.compare(list.get(i), min) >= 0 && comparator.compare(list.get(i), max) <= 0) {
                rangeList.add(list.get(i));
            }
        }
        return rangeList;
    }
}
