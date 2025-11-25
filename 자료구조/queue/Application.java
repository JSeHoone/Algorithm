package queue;

public class Application {
    public static void main(String[] args) {
        // create List Queue
        ListQueueImpl<Integer> queue = new ListQueueImpl<>();

        // push Node
        queue.push(1);
        queue.push(2);
        System.out.println(queue);

        // pop Node
        int value1 = queue.pop();
        System.out.println("추출된 Node : " + value1);
        System.out.println(queue);
        int value2 = queue.pop();
        System.out.println("추출된 Node : " + value2);
        System.out.println(queue);
//        int value3 = queue.pop();
//        System.out.println("추출된 Node : " + value3);


        // create Array Queue
        ArrayQueueImpl q = new ArrayQueueImpl(5);

        // push value
        q.push(1);
        q.push(2);
        System.out.println(q);

        // pop value
        int valueA = (int) q.pop();
        System.out.println("추출된 Value : " + valueA);
        System.out.println(q);
        int valueB = (int) q.pop();
        System.out.println("추출된 Value : " + valueB);
        System.out.println(q);
        int valueC = (int) q.pop();
        System.out.println("추출된 Value : " + valueC);

    }
}
