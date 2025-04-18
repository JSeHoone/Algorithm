import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] students = Arrays.stream(br.readLine().split(" "))
                               .mapToInt(Integer::parseInt)
                               .toArray();

        Queue<Integer> queue = new LinkedList<>();
        for (int s : students) {
            queue.offer(s);
        }
        Stack<Integer> stack = new Stack<>();

        int target = 1;  
        while (!queue.isEmpty()) {
            if (queue.peek() == target) {
                queue.poll();
                target++;
            }
            else if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                target++;
            }
            else {
                stack.push(queue.poll());
            }
        }

        while (!stack.isEmpty() && stack.peek() == target) {
            stack.pop();
            target++;
        }

        System.out.print(target == N + 1 ? "Nice" : "Sad");
    }
}
