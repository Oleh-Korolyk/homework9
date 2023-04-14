package work9;

public class Node<Object> {

    private Node<Object> previousElement;
    private Node<Object> nextElement;
    private Object currentElement;

    public Node(Node<Object> previousElement, Node<Object> nextElement, Object currentElement) {
        this.previousElement = previousElement;
        this.nextElement = nextElement;
        this.currentElement = currentElement;
    }

    public Node<Object> getPreviousElement() {
        return previousElement;
    }

    public void setPreviousElement(Node<Object> previousElement) {
        this.previousElement = previousElement;
    }

    public Node<Object> getNextElement() {
        return nextElement;
    }

    public void setNextElement(Node<Object> nextElement) {
        this.nextElement = nextElement;
    }

    public Object getCurrentElement() {
        return currentElement;
    }

    public void setCurrentElement(Object currentElement) {
        this.currentElement = currentElement;
    }

    @Override
    public String toString() {
        return currentElement.toString();
    }
}
