import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < N ; i++) {
            long cardPack = Long.parseLong(br.readLine());
            pq.add(cardPack);
        }

        long answer = 0;
        while (pq.size() > 1) {
            long a = pq.poll();
            long b = pq.poll();
            long s = a + b;
            answer += s;
            pq.add(s);
        }

        System.out.println(answer);
    }
}