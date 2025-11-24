public class DoubleLinkedList<T> {
    private Node2<T> head;
    private Node2<T> tail;
    private int size;

    // public method
    public void add(int index, Node2<T> value) {
        if (index == 0) {
            // 맨 앞에 값을 추가하는 경우
            head = value;
            value.prev = head;

            tail = value;
            value.next = tail;
        } else if (index == size) {
            // 맨 뒤에 값을 추가하는 경우
            Node2<T> foundNode = findNodeByIndex(size-1);
            foundNode.next = value;
            tail = foundNode;
            value.next = tail;

        }
    }


    // private method
    private Node2<T> findNodeByIndex(int index) {
        if (head == null || index >= size) {
            throw new IndexOutOfBoundsException("Index의 범위를 넘어섰습니다.");
        }

        int nodeIndex = 0;
        Node2<T> pointer = head;
        while (nodeIndex != index) {
            nodeIndex++;
            pointer = pointer.next;
        }
        return pointer;
    }

}
