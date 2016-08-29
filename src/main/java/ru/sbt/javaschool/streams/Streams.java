package ru.sbt.javaschool.streams;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Никита on 29.08.2016.
 */
public class Streams<T> {

    private final List<T> streamList;

    public Streams(List<T> streamList) {
        this.streamList = streamList;
    }

    public static <T> Streams<T> of(List<T> list) {
        return new Streams<>(list);
    }

    public Streams<T> filter(Predicate<? super T> predicate) {
        List<T> filterList = new ArrayList<>();
        for (T t : streamList) {
            if (predicate.test(t)) filterList.add(t);
        }
        return new Streams<>(filterList);
    }

    public <R> Streams<R> transform(Function<? super T, ? extends R> function) {
        List<R> transformList = new ArrayList<>();
        for (T t : streamList) {
            transformList.add(function.apply(t));
        }
        return new Streams<>(transformList);
    }

    public <K, V> Map<K, V> toMap(Function<? super T, ? extends K> key, Function<? super T, ? extends V> value) {
        Map<K, V> map = new HashMap<>();
        for (T t : streamList) {
            map.put(key.apply(t), value.apply(t));
        }
        return map;
    }

}
