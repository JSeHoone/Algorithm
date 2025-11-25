package stack;

public class StackImpl<T> {
    Node<T> peek;
    int size = 0;

    // public method
    public void push(T value) {
        Node<T> node = new Node<>(value);
        node.next = peek;
        peek = node;
        size++;
    }


    public T pop() {
        if (isEmpty()) {
            return null;
        }

        Node<T> tempNode = peek;
        peek = tempNode.next;

        tempNode.next = null;

        size--;
        return tempNode.data;

    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return peek.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // to String

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> pointer = peek;
        sb.append("peek").append(" -> ");
        while (pointer != null) {
            sb.append(pointer.data).append(" -> ");
            pointer = pointer.next;
        }
        sb.append("floor");
        return sb.toString();
    }
}
