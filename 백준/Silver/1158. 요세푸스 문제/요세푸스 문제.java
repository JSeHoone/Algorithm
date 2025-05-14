import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        Queue<Integer> josephus= new LinkedList<>();
        for (int i = 0; i < N; i++) {
            josephus.add(i+1);
        }

        List<Integer> answer = new ArrayList<>();
        int count = 0;
        while (josephus.size() != 0) {
            int num = josephus.poll();
            count++;

            if (count == K) {
                count = 0;
                answer.add(num);
            } else {
                josephus.add(num);
            }
        }



        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for (int i = 0; i < N; i++) {
            if (i == N-1) {
                sb.append(answer.get(i));
            } else {
                sb.append(answer.get(i)).append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);




    }
}
