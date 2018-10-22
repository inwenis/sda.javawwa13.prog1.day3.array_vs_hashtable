package sda;

import java.util.*;
import java.util.stream.Collectors;

public class OurOwnHashMap implements Map<String, Patient> {

    private ArrayList<ArrayList<Patient>> patients;
    private final int capacity;

    public OurOwnHashMap() {
        capacity = 10000000;
        patients = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            patients.add(null);
        }
    }

    public OurOwnHashMap(int capacity) {
        this.capacity = capacity;
        patients = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            patients.add(null);
        }
    }

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
        int hash = hash((String) key);
        ArrayList<Patient> list = patients.get(hash);
        if(list == null) {
            return false;
        } else {
            boolean patientFound = list
                    .stream()
                    .anyMatch(x -> x.Pesel.equals(key));
            return patientFound;
        }
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Patient get(Object key) {
        int hash = hash((String) key);
        ArrayList<Patient> list = patients.get(hash);
        if(list == null) {
            return null;
        }
        else {
            List<Patient> patientsFound = list
                    .stream()
                    .filter(x -> x.Pesel.equals(key))
                    .collect(Collectors.toList());
            if (patientsFound.size() > 1) {
                throw new RuntimeException("This should not happen");
            }
            return patientsFound.get(0);
        }
    }

    private int hash(String s) {
        int hash = 7;
        for (int i = 0; i < s.length(); i++) {
            hash = hash*31 + s.charAt(i);
        }
        hash = Math.abs(hash);
        hash = hash % capacity;
        return hash;
    }

    @Override
    public Patient put(String key, Patient value) {
        int hash = hash(key);
        ArrayList<Patient> list = patients.get(hash);
        if(list == null) {
            patients.set(hash, new ArrayList<>());
            list = patients.get(hash);
        }
        list.add(value);
        return value;
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
