import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        
        StringBuilder response = new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();
        for (int i =0; i < loop; i++) {
            String[] command = br.readLine().split(" ");
            int commandNum = Integer.parseInt(command[0]);
            
            if (commandNum == 1) {
                deque.offerFirst(Integer.parseInt(command[1]));
            } else if (commandNum == 2) {
                deque.offerLast(Integer.parseInt(command[1]));
            } else if (commandNum == 3) {
                Integer num = deque.pollFirst();
                response.append(num == null ? "-1\n" : num + "\n");
            } else if (commandNum == 4) {
                Integer num = deque.pollLast();
                response.append(num == null ? "-1\n" : num + "\n");
            } else if (commandNum == 5) {
                response.append(deque.size()).append("\n");
            } else if (commandNum == 6) {
                response.append(deque.isEmpty() ? "1\n" : "0\n");
            } else if (commandNum == 7) {
                Integer num = deque.peekFirst();
                response.append(num == null ? "-1\n" : num + "\n");
            } else if (commandNum == 8) {
                Integer num = deque.peekLast();
                response.append(num == null ? "-1\n" : num + "\n");
            }
        }
        System.out.print(response);
    }
}
