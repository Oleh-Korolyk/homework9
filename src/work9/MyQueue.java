package work9;

public class MyQueue<E> {

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

    public void clear() {
        if (first == null) return;
        for (int i = 0; first != last; i++) {
            first = first.getNextElement();
            first.setPreviousElement(null);
        }
        first = null;
    }

    public int size() {
        if (first == null) return 0;
        int size = 0;
        current = first;
        for (int i = 0; current != null; i++) {
            size++;
            current = current.getNextElement();
        }
        return size;
    }

    public Node<E> peek() {
        return first;
    }

    public Node<E> poll() {
        if (first == null) return null;
        current = first;
        first = first.getNextElement();
        first.setPreviousElement(null);
        return current;
    }

    public String toString() {
        if (first == null) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        current = first;
        for (int i = 0; current != null; i++) {
            sb.append(current + ", ");
            current = current.getNextElement();
        }
        return sb.toString().substring(0, sb.length() - 2) + "]";
    }

    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue();

        myQueue.add("a");
        myQueue.add("b");
        myQueue.add("c");
        myQueue.add("d");
        myQueue.add("e");

        System.out.println(myQueue);
        System.out.println(myQueue.size());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue);
        System.out.println(myQueue.size());

        myQueue.clear();

        System.out.println(myQueue);
        System.out.println(myQueue.size());

        myQueue.clear();

        System.out.println(myQueue);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());



    }



}
