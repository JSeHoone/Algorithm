package doublelinkedlist;

public class Application {
    public static void main(String[] args) {
        // Node 생성
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);

        // double linked list 생성
        DoubleLinkedList<Integer> doubleList = new DoubleLinkedList<>();

        // 맨 앞에 값을 추가
        doubleList.addFirst(node1);
        doubleList.addFirst(node2);
        System.out.println(doubleList);

        // 맨 뒤에 값을 추가
        doubleList.addLast(node3);
        System.out.println(doubleList);

        // 중간에 값을 추가
        doubleList.add(1, node4);
        doubleList.add(1, node5);
        System.out.println(doubleList);


        // index를 기준으로 값을 삭제
        System.out.println("==== 삭제 메서드 테스트 ====");
        // 맨 앞의 값을 삭제
        doubleList.remove(0);
        System.out.println(doubleList);

        // 맨 뒤의 값을 삭제
        doubleList.remove(doubleList.length()-1);
        System.out.println(doubleList);

        // 중간의 값을 삭제
        doubleList.remove(1);
        System.out.println(doubleList);
    }
}
