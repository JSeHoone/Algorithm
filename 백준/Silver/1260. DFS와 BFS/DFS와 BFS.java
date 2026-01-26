import java.util.*;
import java.io.*;

public class Main {
    static int N, M, start;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        // ⭐ 작은 번호부터 방문하기 위한 정렬 (한 번만)
        for (List<Integer> list : graph.values()) {
            Collections.sort(list);
        }

        visited = new boolean[N + 1];
        dfs(graph, start);
        System.out.println(sb);

        sb.setLength(0);
        visited = new boolean[N + 1];
        bfs(graph, start);
        System.out.println(sb);
    }

    static void dfs(Map<Integer, List<Integer>> graph, int node) {
        visited[node] = true;
        sb.append(node).append(" ");

        for (int next : graph.getOrDefault(node, Collections.emptyList())) {
            if (!visited[next]) {
                dfs(graph, next);
            }
        }
    }

    static void bfs(Map<Integer, List<Integer>> graph, int start) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            for (int next : graph.getOrDefault(cur, Collections.emptyList())) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
