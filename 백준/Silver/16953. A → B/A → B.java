import java.io.*;
import java.util.*;

public class Main {

    static int best = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        long A = Long.parseLong(in[0]), B = Long.parseLong(in[1]);

        Queue<long[]> q = new LinkedList<>();
        q.offer(new long[]{A, 1});

        int answer = -1;
        while (!q.isEmpty()) {
            long[] cur = q.poll();
            long val   = cur[0];
            int  steps = (int)cur[1];

            if (val == B) {
                answer = steps;
                break;
            }
            if (val > B) continue;

            q.offer(new long[]{val * 2,     steps + 1});
            q.offer(new long[]{val * 10 + 1, steps + 1});
        }

        System.out.println(answer);
    }
    
}
