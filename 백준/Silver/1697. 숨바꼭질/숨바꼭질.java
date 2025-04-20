import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] visited = new int[MAX + 1];
        Arrays.fill(visited, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();

            if (x == K) {
                System.out.println(visited[x]);
                return;
            }

            // 가능한 이동: x-1, x+1, x*2
            int[] next = {x - 1, x + 1, x * 2};
            for (int nx : next) {
                if (nx >= 0 && nx <= MAX && visited[nx] == -1) {
                    visited[nx] = visited[x] + 1;
                    q.add(nx);
                }
            }
        }
    }
}
