package work9.MyHashMap;

import java.util.Objects;

public class MapNode<String, E> {

    private final int hash;
    private final String key;
    private E value;
    private MapNode<String, E> nextElement;

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    public MapNode(int hash, String key, E value, MapNode<String, E> nextElement) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.nextElement = nextElement;
    }

    public int getHash() {
        return hash;
    }

    public String getKey() {
        return key;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public MapNode<String, E> getNextElement() {
        return nextElement;
    }

    public void setNextElement(MapNode<String, E> nextElement) {
        this.nextElement = nextElement;
    }

    @Override
    public java.lang.String toString() {
        return "MapNode{" +
                "hash=" + hash +
                ", key=" + key +
                ", value=" + value +
                ", nextElement=" + nextElement +
                '}';
    }
}
