package stack;

public class Application {
    public static void main(String[] args) {
        // create stack
        ListStackImpl<Integer> stack = new ListStackImpl<>();

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

        System.out.println("=== Array Stack ===");
        // create array Stack
        ArrayStackImpl stack2 = new ArrayStackImpl(5);

        // push
        stack2.push(1);
        stack2.push(2);
        System.out.println(stack2);

        // pop
        int value1 = (int) stack2.pop();
        System.out.println("추출된 Node : " + value1);
        System.out.println(stack2);
        int value2 = (int) stack2.pop();
        System.out.println("추출된 Node : " + value2);

    }
}
