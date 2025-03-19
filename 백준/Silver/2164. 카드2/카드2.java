import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        // queue 생성
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        
        while (queue.size() != 1) {
            // 첫번째 카드 제거
            queue.poll();
            // 두번째 카드 추출
            int second = queue.peek();
            // 두번째 카드 아래로 
            queue.offer(second);
            // 두번째 카드 제거
            queue.poll();
        }
        
        System.out.println(queue.peek());
        
        
        
    }
}