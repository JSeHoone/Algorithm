import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }


        Deque<Integer> dq = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int init = Integer.parseInt(st.nextToken());
            if (A[i] == 0) {
                dq.addLast(init);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (dq.isEmpty()) {
                sb.append(x);
            } else {
                dq.addFirst(x);
                sb.append(dq.pollLast());
            }
            if (i < M - 1) sb.append(' ');
        }

        System.out.println(sb);
    }
}
