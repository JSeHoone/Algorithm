import java.util.*;
import java.io.*;

/*
1. 연산의 갯수(N)가 주어진다.
2. N개의 줄에 연산에 대한 정보를 나타내는 x가 주어진다.
3. x가 0이면 출력하고, 자연수이면 배열에 값을 넣는다.

*/
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 우선순위 큐 정의하기
        PriorityQueue<Integer> pq = new PriorityQueue<>();


        // N 
        Integer N = Integer.parseInt(br.readLine());

        // task loop
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int commandNum = Integer.parseInt(br.readLine());

            if (commandNum == 0) {
                Integer extractNum = pq.poll();
                if (extractNum == null) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(extractNum).append("\n");
                }
            } else {
                pq.add(commandNum);
            }
        }

        // output
        System.out.println(sb);
    } 
}