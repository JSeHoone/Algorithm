import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        int loop = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= loop; i++) {
            int command = Integer.parseInt(br.readLine());
            
            if (command == 0) {
                Integer number = maxHeap.poll();
                if (number == null) {
                    System.out.println("0");
                } else {
                    System.out.println(number);
                }
            } else {
                 maxHeap.add(command);
            }
            
        }
    }
}