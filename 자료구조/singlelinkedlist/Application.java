package singlelinkedlist;

public class Application {
    public static void main(String[] args) {

        // Node 생성
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);

        // LinkedList 생성
        SingleLinkedList<Integer> singleList = new SingleLinkedList<>();

        // 맨 앞에 값을 추가
        singleList.addFirst(node1);
        singleList.addFirst(node2);
        System.out.println(singleList);

        // 맨 뒤에 값을 추가
        singleList.addLast(node3);
        System.out.println(singleList);

        // 중간에 값을 추가
        singleList.add(1, node4);
        singleList.add(1, node5);
        System.out.println(singleList);

        // index를 기준으로 값을 삭제
        System.out.println("==== 삭제 메서드 테스트 ====");
        // 맨 앞의 값을 삭제
        singleList.remove(0);
        System.out.println(singleList);

        // 맨 뒤의 값을 삭제
        singleList.remove(singleList.length()-1);
        System.out.println(singleList);

        // 중간의 값을 삭제
        singleList.remove(1);
        System.out.println(singleList);

    }
}
