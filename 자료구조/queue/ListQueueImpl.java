package queue;

public class ListQueueImpl<T> {
    // 값을 빼는 곳
    private Node<T> front;

    // 값을 넣어야 하는 곳
    private Node<T> rear;
    private int size;

    /*public method*/
    public void push(T value) {
        Node<T> node = new Node<>(value);
        if (front == null) {
            front = node;
            rear = node;
        } else {
            Node<T> tempNode = rear;
            rear.prev = node;
            rear = node;
        }
        size++;
    }

    public T pop() {
        if (isEmpty()) return null;
        Node<T> currentNode = front;
        front = currentNode.prev;

        size--;
        return currentNode.data;
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
        sb.append("front").append("->");
        Node<T> pointer = front;
        while (pointer != null) {
            sb.append(pointer.data).append("->");
            pointer = pointer.prev;
        }
        sb.append("rear");

        return sb.toString();
    }
}
