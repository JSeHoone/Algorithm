public class SingleLinkedList <T> {
    private Node<T> head;
    private int size;

    // public method

    /**
     * 맨 앞에 데이터를 추가하는 경우
     * @param node 추가하고자 하는 Node
    * */
    public void addFirst(Node<T> node) {
        // Head가 넣으려고 하는 node를 바라보도록 하고, 기존의 head node는 next가 된다.
        Node<T> tempNode = head;
        head = node;
        head.next = tempNode;
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
        Node pointer = head;
        stringBuilder.append("head").append(" -> ");
        while (null != pointer) {
            stringBuilder.append(pointer.data).append(" -> ");
            pointer = pointer.next;
        }
        stringBuilder.append("null");
        return stringBuilder.toString();
    }
}
