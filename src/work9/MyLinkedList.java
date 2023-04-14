package work9;

import work9.fruits.Apple;
import work9.fruits.Pear;
import work9.fruits.Pineapple;

public class MyLinkedList<E> {

    Node<E> first;
    Node<E> last;
    Node<E> current;


    public void add(E value) {

        if (first == null) {
            first = new Node<>(null, null, value);
        } else if (last == null) {
            last = new Node<>(first, null, value);
            first.setNextElement(last);
        } else {
            current = new Node<>(last, null, value);
            last.setNextElement(current);
            last = current;
        }
    }

    public void remove(int index) {
        if (index < 0 || index > size() - 1) {
            return;
        }
        if (last == null) {
            first = null;
            return;
        }
        if (first.getNextElement() == last) {
            if (index == 0) {
                first = first.getNextElement();
                first.setPreviousElement(null);
                last = null;
                return;
            }
            first.setNextElement(null);
            last = null;
            return;
        }
        if (index == 0) {
            first = first.getNextElement();
            first.setPreviousElement(null);
            return;
        }
        if (index == size() - 1) {
            last = last.getPreviousElement();
            last.setNextElement(null);
            return;
        }
        current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNextElement();
        }
        Node<E> currentPreviousElement = current.getPreviousElement();
        Node<E> currentNextElement = current.getNextElement();
        currentPreviousElement.setNextElement(currentNextElement);
        currentNextElement.setPreviousElement(currentPreviousElement);
    }

    public void clear() {
       if (first == null) return;
        last = null;
        first = null;

    }

    public int size() {
        int size = 0;
        if (first == null) {
            return 0;
        }
        current = first;
        for (int i = 0; current != null; i++) {
            size++;
            current = current.getNextElement();
        }
        return size;
    }

    public E get(int index) {
        if (index < 0 || index > size() - 1) {
            return null;
        }
        current = first;
          for (int i = 0; i < index; i++) {
              current = current.getNextElement();
        }

        return current.getCurrentElement();
    }

    @Override
    public String toString() {
        current = first;
        if (first == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; current != null; i++){
            sb.append(current + ", ");
            current = current.getNextElement();
        }
        return sb.toString().substring(0, sb.length() - 2) + "]";


    }

    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.add("a");
        myLinkedList.add("a");
        myLinkedList.add(new Apple());
        myLinkedList.add(5);
        myLinkedList.add('&');
        myLinkedList.add(new Pear());
        myLinkedList.add(9f);
        myLinkedList.add(new Fruits());
        myLinkedList.add(new Pineapple());

        System.out.println(myLinkedList.get(7));
        System.out.println(myLinkedList.get(-25));
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.last);
        System.out.println(myLinkedList.last.getPreviousElement());
        System.out.println(myLinkedList.last.getNextElement());
        System.out.println(myLinkedList.size());
        System.out.println(myLinkedList);
        myLinkedList.remove(0);
        System.out.println(myLinkedList);
        myLinkedList.remove(0);
        System.out.println(myLinkedList);
        myLinkedList.add(9f);
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.size());
        myLinkedList.remove(0);
        myLinkedList.remove(0);
        myLinkedList.remove(0);
        myLinkedList.remove(0);
        myLinkedList.remove(0);
        myLinkedList.remove(0);
        myLinkedList.remove(0);
        myLinkedList.remove(0);

        myLinkedList.clear();

        System.out.println(myLinkedList);
        System.out.println(myLinkedList.size());

        myLinkedList.clear();
        myLinkedList.add(9f);
        myLinkedList.add("d");
        myLinkedList.add("dsc");
        System.out.println(myLinkedList);
        myLinkedList.remove(1);
        System.out.println(myLinkedList);
        myLinkedList.remove(0);
        System.out.println(myLinkedList);
        myLinkedList.remove(0);
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.get(0));

    }
}
