import java.io.*;
import java.util.*;

public class Main {
    static boolean isBipartite;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int V = input[0], E = input[1];
            isBipartite = true;
            int[] visited = new int[V+1];

            List<List<Integer>> graph = new ArrayList<>();
            // create V
            for (int j = 0; j < V+1; j++) {
                List<Integer> data = new ArrayList<>();
                graph.add(data);
            }

            // link E
            for (int k = 0; k < E; k++) {
                int[] edgeInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                graph.get(edgeInfo[0]).add(edgeInfo[1]);
                graph.get(edgeInfo[1]).add(edgeInfo[0]);
            }

            // check isBipartite
            for (int l = 1; l < V+1; l++) {
                if (!isBipartite) {
                    break;
                }

                if (visited[l] == 0) {
                    bfs(graph,l, visited);
                }
            }

            // output
            System.out.println(isBipartite ? "YES" : "NO");

        }
    }

    private static void bfs(List<List<Integer>> graph, int startV, int[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startV);
        visited[startV] = 1;

        while (!q.isEmpty() && isBipartite) {
            int v = q.poll();

            for (int edge : graph.get(v)) {
                if (visited[edge] == 0) {
                    q.add(edge);
                    visited[edge] = visited[v] * -1;
                } else if (visited[v] + visited[edge] != 0) {
                    isBipartite = false;
                    return;
                }
            }
        }

    }


}
