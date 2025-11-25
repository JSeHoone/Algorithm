package queue;

public class Node<T> {
    Node<T> prev;
    T data;

    public Node(T data) {
        this.data = data;
    }
}
