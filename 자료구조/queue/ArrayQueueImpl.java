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
        // TODO : GPT에 물어보니 Full condition이 아니라고 함 !..
        if (front == rear && queue[rear] != null) {
            throw new RuntimeException("배열이 꽉 찼습니다.");
        }

        queue[rear] = value;
        rear = (rear+1) % queue.length;
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
        if (rear >= front) {
            return rear - front;
        } else {
            return queue.length - (front - rear);
        }
    }

    public boolean isEmpty() {
        return front == rear && queue[front] == null;
    }

    //toString

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("front -> ");

        int index = front;
        while (queue[index] != null) {
            sb.append(queue[index]).append("->");
            index = (index + 1) % queue.length;

            if (index == rear) break;
        }
        sb.append("rear");
        return sb.toString();
    }
}

