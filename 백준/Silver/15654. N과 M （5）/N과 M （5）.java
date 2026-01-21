import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[] nodes;
    private static int[] visited;
    private static StringBuilder sb = new StringBuilder();

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); // node
        M = Integer.parseInt(input[1]); // depth
    
        nodes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        visited = new int[M];
        Arrays.sort(nodes);

        backTracking(0);
        System.out.println(sb);
        
    }

    private static void backTracking(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(visited[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            int node = nodes[i];
            if (!existNode(node)) {
                visited[depth] = node;
                backTracking(depth+1);
                visited[depth] = 0; // 초기화 
            }
        }
    }

    private static boolean existNode(int node) {
        if (visited.length == 0) return false;
        
        for (int visitedNode : visited) {
            if (visitedNode == node) {
                return true;
            }
        }

        return false;
    }
}