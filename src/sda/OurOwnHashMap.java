package sda;

import java.util.*;
import java.util.stream.Collectors;

public class OurOwnHashMap implements Map<String, Patient> {

    private ArrayList<ArrayList<Patient>> patients;

    // TODO this is the place where you have to work
    // it's probably best to start with the `put()` method
    // for simple tests you can use `OutOwnHashMapTests.main()`

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        // TODO implement
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Patient get(Object key) {
        // TODO implement
        return null;
    }

    private int hash(String s) {
        // TODO implement
        return 0;
    }

    @Override
    public Patient put(String key, Patient value) {
        // TODO implement
        return null;
    }

    @Override
    public Patient remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Patient> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<String> keySet() {
        return null;
    }

    @Override
    public Collection<Patient> values() {
        return null;
    }

    @Override
    public Set<Entry<String, Patient>> entrySet() {
        return null;
    }
}
