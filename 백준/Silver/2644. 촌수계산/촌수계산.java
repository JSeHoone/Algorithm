import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        
        int m = Integer.parseInt(br.readLine());
        
        
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        
        System.out.println(bfs(adj, start, target, n));
    }

    private static int bfs(List<Integer>[] adj, int start, int target, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] { start, 0 });
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0], dist = cur[1];
            if (node == target) {
                return dist;
            }
            for (int next : adj[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[] { next, dist + 1 });
                }
            }
        }

        return -1;
    }
}
