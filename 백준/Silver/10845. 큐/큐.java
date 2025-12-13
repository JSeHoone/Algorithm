import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        // queue;
        Deque<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            String command = inputs[0];
            
            switch (command) {
                case "push" :
                    int value = Integer.parseInt(inputs[1]);
                    q.add(value);
                    break;
                    
                case "pop" :
                    System.out.println(q.isEmpty() ? -1 : q.pollFirst());
                    break;
                case "size" :
                    System.out.println(q.size());
                    break;
                case "empty" :
                    System.out.println(q.isEmpty() ? 1 : 0);
                    break;
                case "front" :
                    System.out.println(q.isEmpty() ? -1 : q.peekFirst());
                    break;
                case "back" :
                    System.out.println(q.isEmpty() ? -1 : q.peekLast());
                    break;
            }
        }
    }
}