package work9.MyHashMap;

import work9.Fruits;
import work9.fruits.*;

import java.util.Arrays;
import java.util.Objects;

public class MyHashMap<String, E> {

    private static int n = 4;
    private String key;
    MapNode<String, E> previous;
    MapNode<String, E> current;
    MapNode<String, E> next;
    public MapNode<String, E>[] chain = new MapNode[n];

    public void put(String key, E value) {
        int index = Math.abs(key.hashCode() % n);
        if (chain[index] == null) {
            chain[index] = new MapNode<>(key.hashCode(), key, value, null);
        } else {
            for (current = chain[index]; current != null; current = current.getNextElement()) {
                if (current.getHash() == key.hashCode() && (current.getKey() == key || (key != null && key.equals(current.getKey())))) {
                    current.setValue(value);
                    return;
                } else if (current.getNextElement() == null) {
                    next = new MapNode<>(key.hashCode(), key, value, null);
                    current.setNextElement(next);
                }
            }
        }
    }

    public void remove(java.lang.String key) {
        int index = Math.abs(key.hashCode() % n);
        previous = null;
        for (current = chain[index]; current != null; current = current.getNextElement()) {
            if (current.getHash() == key.hashCode() && (current.getKey() == key || (key != null && key.equals(current.getKey())))) {
                if (previous != null) {
                    previous.setNextElement(current.getNextElement());
                    current = null;
                    break;
                } else if (current.getNextElement() == null){
                    chain[index] = null;
                    break;
                } else {
                    chain[index] = current.getNextElement();
                    current = null;
                    break;
                }
            }
            previous = current;
        }

    }

    public void clear() {
        for (int i = 0; i < n; i++) {
           chain[i] = null;
        }
    }

    public int size() {
        int size = 0;
        for (int i = 0; i < n; i++) {
            for (current = chain[i]; current != null; current = current.getNextElement()) {
                size++;
            }
        }
        return size;
    }

    public E get(String key) {
        int index = Math.abs(key.hashCode() % n);
        for (current = chain[index]; current != null; current = current.getNextElement()) {
            if (current.getHash() == key.hashCode() && (current.getKey() == key || (key != null && key.equals(current.getKey())))) {
            return current.getValue();
            }
        }
       return null;
    }



    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    @Override
    public java.lang.String toString() {
        return "MyHashMap{" +
                "chain" + Arrays.toString(chain) +
                '}';
    }

    public static void main(java.lang.String[] args) {

        MyHashMap myHashMap = new MyHashMap();


        myHashMap.put("pineapple", new Pineapple());
        myHashMap.put("pineapple","#####");
        myHashMap.put("apple", new Apple());
        myHashMap.put("orange", new Orang());
        myHashMap.put("lemon", new Lemon());
        myHashMap.put("fruits", new Fruits());
        myHashMap.put("b", "BBB");
        myHashMap.put("pineapple","#####");
        System.out.println("apple".hashCode());
        myHashMap.put("pear", new Pear());
        myHashMap.put("cherry", "cherry");
        myHashMap.put("a", "AAA");
        myHashMap.put("pineapple", new Pineapple());
        myHashMap.put("c", "CCC");
        myHashMap.put("d", "DDD");
        myHashMap.put("e", "EEE");
        myHashMap.put("f", "FFF");


        System.out.println(myHashMap);

        for (int i = 0; i < n; i++) {
            System.out.println(myHashMap.chain[i]);
        }

        System.out.println("Hello World!");

        myHashMap.remove("t");
        myHashMap.remove("b");

        System.out.println(myHashMap.size());
        System.out.println(myHashMap.get("a"));
        System.out.println(myHashMap.get("pineapple"));

        for (int i = 0; i < n; i++) {
            System.out.println(myHashMap.chain[i]);
        }

        myHashMap.clear();
        System.out.println(myHashMap.get("a"));
        System.out.println(myHashMap.get("t"));
        myHashMap.remove("b");
        myHashMap.clear();

        myHashMap.put("f", "FFF");

        for (int i = 0; i < n; i++) {
            System.out.println(myHashMap.chain[i]);
        }

    }


}
