package lab2.task1;

public class Node<T> {
    public T data;
    public Node<T> next;
    public Node<T> prev;

    Node(final Node<T> prev, final T element, final Node<T> next) {
        this.data = element;
        this.next = next;
        this.prev = prev;
    }
}
