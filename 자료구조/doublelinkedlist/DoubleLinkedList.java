public class DoubleLinkedList<T> {
    private Node2<T> head;
    private Node2<T> tail;
    private int size = 0;

    // public method
    public void add(int index, Node2<T> value) {
        if (index == 0) {
            // 맨 앞에 값을 추가하는 경우
            value.next = head;
            head = value;

            tail = value.next;
        } else if (index == size) {
            // 맨 뒤에 값을 추가하는 경우
            Node2<T> currentTailNode = tail;
            currentTailNode.next = value;
            value.prev = currentTailNode;
            tail = value;
        } else {
            // 중간에 값을 추가하는 경우
            Node2<T> preNode = findNodeByIndex(index-1);
            Node2<T> currentNode = findNodeByIndex(index);

            preNode.next = value;
            value.prev = preNode;
            value.next = currentNode;
            currentNode.prev = value;
        }

        size++;
    }

    public void addFirst(Node2<T> value) {
        add(0, value);
    }

    public void addLast(Node2<T> value) {
        add(size, value);
    }

    public int length() {
        return size;
    }

    public void remove(int index) {
        if (index == 0) {
            // 맨 앞의 값을 삭제하는 경우
            Node2<T> currentHeadNode = head;

            head = currentHeadNode.next;
            currentHeadNode.next = null;
        } else if (index == (size-1)) {
            // 맨 뒤의 값을 삭제하는 경우
            Node2<T> currentLastNode = tail;
            tail = currentLastNode.prev;

            tail.next = null;
            currentLastNode.next = null;
        } else {
            // 중간에 값을 삭제하는 경우
            Node2<T> preNode = findNodeByIndex(index-1);
            Node2<T> currentNode = findNodeByIndex(index);
            Node2<T> postNode = findNodeByIndex(index+1);

            preNode.next = postNode;
            postNode.prev = preNode;
            currentNode.prev = null;
            currentNode.next = null;
        }

        size--;
    }


    // private method
    private Node2<T> findNodeByIndex(int index) {
        if (head == null || index >= size) {
            throw new IndexOutOfBoundsException("Index의 범위를 넘어섰습니다.");
        }

        // index가 절반 이상이면 tail에서 찾는 것이 더 효율적 !
        Node2<T> pointer;
        if ((index / 2) > size) {
            int nodeIndex = size-1;
            pointer = tail;
            while (nodeIndex != index) {
                nodeIndex--;
                pointer = pointer.prev;
            }
        } else {
            int nodeIndex = 0;
            pointer = head;
            while (nodeIndex != index) {
                nodeIndex++;
                pointer = pointer.next;
            }
        }

        return pointer;
    }

    // to String
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node2<T> pointer = head;
        sb.append("head").append("->");
        while (null != pointer) {
            sb.append(pointer.data).append("->");
            pointer = pointer.next;
        }

        sb.append("null");
        return sb.toString();
    }
}
