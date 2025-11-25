package stack;

import java.util.Stack;

public class Application {
    public static void main(String[] args) {
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
