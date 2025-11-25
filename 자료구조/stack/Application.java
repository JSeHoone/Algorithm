package stack;

import java.util.Stack;

public class Application {
    public static void main(String[] args) {
        // create Node
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);

        // create stack
        StackImpl<Integer> stack = new StackImpl<>();

        // push Node
        stack.push(1);
        stack.push(2);
        System.out.println(stack);

        // pop Node
        int peekNode = stack.pop();
        System.out.println("추출된 Node : " + peekNode);
        System.out.println(stack);
        int peekNode2 = stack.pop();
        System.out.println("추출된 Node : " + peekNode2);
    }
}
