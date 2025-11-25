package singlelinkedlist;

public class SingleLinkedList <T> {
    private Node<T> head;
    private int size;

    // public method

    /**
     * 맨 앞에 데이터를 추가하는 로직
     * @param value 추가하고자 하는 Node
    * */
    public void addFirst(Node<T> value) {
        add(0, value);
    }

    /**
     * 맨 뒤에 데이터를 추가하는 로직
     * @param value 추가하고자 하는 Node
    * */
    public void addLast(Node<T> value) {
        add(size,value);
    }

    /**
     * 원하는 index내에 데이터를 추가하는 로직
     * @param index index 위치
     * @param value 추가하고자 하는 Node
    * */
    public void add(int index, Node<T> value) {

        if (index == 0) {
            // 맨 앞에 값을 추가하는 경우
            value.next = head;
            head = value;
        } else if (index == size) {
            // 맨 뒤에 값을 추가하는 경우
            Node<T> findedNode = findNodeByIndex(size-1);
            findedNode.next = value;
        } else {
            // 중간에 값을 추가하는 경우
            Node<T> preNode = findNodeByIndex(index-1);
            Node<T> currentNode = findNodeByIndex(index);

            preNode.next = value;
            value.next = currentNode;
        }

        size++;
    }

    /**
     * 원하는 index에 위치하고 있는 데이터를 삭제하는 로직
     * @param index index 위치
    * */
    public void remove(int index) {
        if (index == 0) {
            // 맨 앞의 값을 삭제 하는 경우
            head = findNodeByIndex(index+1);
        } else if (index == (size-1)) {
            // 맨 뒤의 값을 삭제하는 경우
            Node<T> updatedLastNode = findNodeByIndex(index-1);
            updatedLastNode.next = null;
        } else {
            // 중간에 값을 삭제하는 경우
            Node<T> preNode = findNodeByIndex(index-1);
            Node<T> currentNode = findNodeByIndex(index);

            preNode.next = findNodeByIndex(index+1);
            currentNode.next = null;
        }

        size--;
    }

    /**
     * SingleLinkedList의 크기를 얻기 위한 메서드
    * */
    public int length() {
        return size;
    }

    // private method

    /**
     * index를 기준으로 Node를 찾는 메서드
     * @param index index 번호
     * @return Node
    * */
    private Node<T> findNodeByIndex(int index) {

        if (head == null || index >= size) {
            throw new IndexOutOfBoundsException("Index의 범위를 넘었습니다.");
        }

        int nodeIndex = 0;
        Node<T> pointer = head;
        while(nodeIndex != index) {
            nodeIndex++;
            pointer = pointer.next;
        }

        return pointer;
    }

    // to String
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<T> pointer = head;
        stringBuilder.append("head").append(" -> ");
        while (null != pointer) {
            stringBuilder.append(pointer.data).append(" -> ");
            pointer = pointer.next;
        }
        stringBuilder.append("null");
        return stringBuilder.toString();
    }
}
