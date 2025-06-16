import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int M;
    private static int V;
    private static LinkedList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); // 노드 수
        M = Integer.parseInt(input[1]); // 간선 수
        V = Integer.parseInt(input[2]); // 시작 노드

        // make graph
        graph = new LinkedList[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new LinkedList<>();
        }

        // linked edge
        for (int i=0; i < M; i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        // bfs & dfs
        StringBuilder sb = new StringBuilder();
        dfs(sb);
        sb.append("\n");
        bfs(sb);
        System.out.println(sb);

    }

    private static void dfs(StringBuilder sb) {
        boolean[] visited = new boolean[N+1];
        Stack<Integer> stack = new Stack<>();
        stack.push(V);

        while(!stack.isEmpty()) {
            int current = stack.pop();

            if (!visited[current]) {
                visited[current] = true;
                sb.append(current).append(" ");

                // current의 주변 확인
                List<Integer> neighbors = graph[current];
                neighbors.sort(Comparator.reverseOrder()); // 작은 순서로 넣기 위함.

                for (int neighbor : neighbors) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }

    }

    private static void bfs(StringBuilder sb) {
        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(V);

        while (!q.isEmpty()) {
            int current = q.poll();

            if (!visited[current]) {
                visited[current] = true;
                sb.append(current).append(" ");

                List<Integer> neighbors = graph[current];
                neighbors.sort(Comparator.naturalOrder()); // 작은 순서로 넣기 위함.

                for (int neighbor : neighbors) {
                    if (!visited[neighbor]) {
                        q.add(neighbor);
                    }
                }
            }
        }
    }
}
