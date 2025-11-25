package stack;

public class ArrayStackImpl {
    private final Object[] stack;

    private int peekIndex = -1;

    public ArrayStackImpl(int size) {
        this.stack = new Object[size];
    }

    /*public method*/
    public void push(Object value) {
        if (peekIndex  == (stack.length -1)) {
            throw new RuntimeException("Stack이 다 찼습니다.");
        }

        stack[++peekIndex] = value;
    }

    public Object pop() {
        if (peekIndex == -1) {
            throw new RuntimeException("Stack이 비어있습니다.");
        }

        Object tempValue = stack[peekIndex];
        stack[peekIndex] = null;
        peekIndex--;
        return tempValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("peek -> ");

        for (int i = peekIndex; i >= 0; i--) {
            sb.append(stack[i]).append(" -> ");
        }

        sb.append("floor");
        return sb.toString();
    }


}
