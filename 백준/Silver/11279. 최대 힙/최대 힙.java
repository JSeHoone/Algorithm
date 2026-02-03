import java.util.*;
import java.io.*;

/*
최대 힙을 만들어야 함.

0이 들어오면 출력
자연수가 들어오면 x에 넣는 작업을 한다.
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // create max heap
        // 오름차순으로 정렬하기 위해 Comparator.reverseOrder()를 넣어줌.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int commandNum = Integer.parseInt(br.readLine());

            if (commandNum == 0) {
                Integer peekNum = maxHeap.poll();
                if (peekNum == null) {
                    sb.append("0").append("\n");
                } else {
                    sb.append(peekNum).append("\n");
                }
            } else{
                maxHeap.add(commandNum);
            }
        }

        System.out.println(sb);
    }
}