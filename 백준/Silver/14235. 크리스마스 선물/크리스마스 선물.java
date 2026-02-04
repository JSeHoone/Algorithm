import java.io.*;
import java.util.*;

/*
아이들과 거점지에 방문한 횟수 N이 주어진다.
a가 0이라면 아이들을 만난 것 (출력해야 하는 것)

2 3 2
-> 2개의 숫자 (3,2)라는 가치의 선물이 들어온다는 의미인 것 같음
*/
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int loop = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i <loop; i++) {
            String[] command = br.readLine().split(" ");

            // 아이들을 만난 경우
            if (command.length == 1) {
                Integer peekNum = pq.poll();
                if (peekNum == null) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(peekNum).append("\n");
                }
            } else {
                // 선물이 들어오는 경우
                int giftCount = Integer.parseInt(command[0]);
                for (int j = 1; j <= giftCount; j++) {
                    pq.add(Integer.parseInt(command[j]));
                }
            }
        }

        System.out.println(sb);
        
    }
}