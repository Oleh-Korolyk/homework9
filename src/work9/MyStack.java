package work9;

public class MyStack<E> {
    Node<E> first;
    Node<E> last;
    Node<E> current;


    public void push(E value) {

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
        if (index == 0) {
            last = last.getPreviousElement();
            last.setNextElement(null);
            return;
        }
        if (index == size() - 1) {
            first = first.getNextElement();
            first.setPreviousElement(null);
            return;
        }
        current = last;
            for (int i = 0; i < index; i++) {
            current = current.getPreviousElement();
        }
        Node<E> currentPreviousElement = current.getPreviousElement();
        Node<E> currentNextElement = current.getNextElement();
        currentPreviousElement.setNextElement(currentNextElement);
        currentNextElement.setPreviousElement(currentPreviousElement);
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

    public E peek() {
        if (first == null) return null;
        if (last == null) return first.getCurrentElement();
        return last.getCurrentElement();
    }

    public E pop() {
        if (first == null) return null;
        if (last == null) {
            current = first;
            first = null;
            return current.getCurrentElement();
        }
        current = last;
        last = last.getPreviousElement();
        last.setNextElement(null);
        return current.getCurrentElement();
    }

    @Override
    public String toString() {
        if (first == null) {
            return "[]";
        }
        current = last;
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; current != null; i++){
            sb.append(current + ", ");
            current = current.getPreviousElement();
        }
        return sb.toString().substring(0, sb.length() - 2) + "]";
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        myStack.push("a");
        myStack.push("b");
        myStack.push("c");
        myStack.push("d");
        myStack.push("e");
        myStack.push(4);
        System.out.println(myStack);
        System.out.println(myStack.peek());
        System.out.println(myStack.size());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack);
        myStack.remove(1);
        System.out.println(myStack);
        myStack.clear();
        myStack.clear();
        System.out.println(myStack);
        System.out.println(myStack.peek());
        System.out.println(myStack.size());
        System.out.println(myStack.pop());
        myStack.remove(1);





    }

}
