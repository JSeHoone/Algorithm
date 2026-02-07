import java.util.*;
import java.io.*;
import java.lang.*;

/*
입력되는 값이 0이 아니면 add
0이면 출력하도록 로직 설정

*/
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 연산의 갯수
        int N = Integer.parseInt(br.readLine());

        // PriorityQueue 배열로 정의하기
        // [{절대값}, {원본 값}]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.<int[]>comparingInt(x -> x[0])
                      .thenComparingInt(x -> x[1])
        );

        // 입력 받기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int commandNum = Integer.parseInt(br.readLine());

            if (commandNum == 0) {
                if (pq.size() == 0) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()[1]).append("\n");
                }
                continue;
            }

            int[] unit = new int[]{Math.abs(commandNum), commandNum};
            pq.add(unit);
        }

        System.out.println(sb);
        
    }
}