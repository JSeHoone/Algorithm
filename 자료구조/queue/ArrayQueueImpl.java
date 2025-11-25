package queue;

public class ArrayQueueImpl {
    private final Object[] queue;

    private int front = 0;
    private int rear = 0;

    public ArrayQueueImpl(int size) {
        this.queue = new Object[size];
    }

    /*public method*/
    public void push(Object value) {
        if (front == rear && queue[rear] != null) {
            throw new RuntimeException("배열이 꽉 찼습니다.");
        }

        queue[rear] = value;
        rear++;
    }

    public Object pop() {
        if (front == rear && queue[front] == null) {
            throw new RuntimeException("Queue가 비어있습니다.");
        }

        Object returnValue = queue[front];
        queue[front] = null;
        front = (front+1) % queue.length;
        return returnValue;
    }

    public int size() {
        return queue.length;
    }

    public boolean isEmpty() {
        return queue.length == 0;
    }

    //toString

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("front").append("->");

        int index = front;
        Object pointer = queue[index];
        while (pointer != null) {
            sb.append(pointer).append("->");
            index = (index+1) % queue.length;
        }
        sb.append("rear");
        return sb.toString();
    }
}

