public class Application {
    public static void main(String[] args) {
        Node<Integer> newNode = new Node<>(1);
        Node<Integer> nextNode = new Node<>(2);

        SingleLinkedList<Integer> singleList = new SingleLinkedList<>();
        singleList.addFirst(newNode);
        singleList.addFirst(nextNode);

        System.out.println(singleList);

    }
}
