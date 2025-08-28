import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] bridge = Arrays.stream(br.readLine().split(" "))
                             .mapToInt(Integer::parseInt).toArray();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1; // 
        int end   = Integer.parseInt(st.nextToken()) - 1; //

        boolean[] visited = new boolean[N];
        Queue<int[]> q = new LinkedList<>();

        visited[start] = true;
        q.add(new int[]{start, 0}); 

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int pos = cur[0];
            int dist = cur[1];

            if (pos == end) {
                System.out.println(dist);
                return;
            }

            int step = bridge[pos];

            for (int next = pos + step; next < N; next += step) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, dist + 1});
                }
            }

            for (int next = pos - step; next >= 0; next -= step) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, dist + 1});
                }
            }
        }

        System.out.println(-1);
    }
}
