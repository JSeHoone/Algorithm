import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int M;
    private static HashMap<Integer, List<Integer>> graph;
    private static int[] visited;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        if (M == 0) {
            System.out.println(N);
        } else {
            graph = new HashMap<>();
            visited = new int[N+1];
            Arrays.fill(visited, 1);

            for (int i = 1; i <= M; i++) {
                String[] link = br.readLine().split(" ");
                int node1 = Integer.parseInt(link[0]);
                int node2 = Integer.parseInt(link[1]);
                graph.computeIfAbsent(node1, k -> new LinkedList<>()).add(node2);
                graph.computeIfAbsent(node2, k -> new LinkedList<>()).add(node1);
            }

            for (int i = 1; i <= N; i++) {
                boolean a = dfs(i);
                if (a == true) {
                    count++;
                }
            }
            System.out.println(count);
        }


    }

    private static boolean dfs(int node) {
        if (visited[node] == 0) {
            return false;
        }

        visited[node] = 0;
        List<Integer> link = graph.get(node);
        if (link == null) {
            return true;
        }

        for (int linkedNode : link) {
            if (visited[linkedNode] == 0) {
                continue;
            }
            dfs(linkedNode);
        }
        return true;
    }
}