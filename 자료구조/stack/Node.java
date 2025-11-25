package stack;

public class Node<T> {
    Node<T> next = null;
    T data;

    public Node(T data) {
        this.data = data;
    }
}
