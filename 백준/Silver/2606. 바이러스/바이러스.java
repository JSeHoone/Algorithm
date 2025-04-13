import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());
        int network = Integer.parseInt(br.readLine());
        
        LinkedList<Integer>[] graph = new LinkedList[node+1];
        
        for (int i = 1; i <= node; i++) {
            graph[i] = new LinkedList<>();
        }
        
        for (int i = 1; i <= network; i++) {
            int[] networkState = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph[networkState[0]].add(networkState[1]);
            graph[networkState[1]].add(networkState[0]);
        }
        
        // dfs
        boolean[] visited = new boolean[node+1];
        visited[1] = true;
        for (int computer : graph[1]) {
            visited[computer] = true;
            dfs(graph, visited, computer);
        }
        
        int count = -1;
        for (boolean visit : visited) {
            if (visit) {
                count++;
            }
        }
        
        System.out.print(count);
        
    }
    
    public static void dfs(LinkedList<Integer>[] graph, boolean[] visited, int computer) {
        for (int num : graph[computer]) {
            if (visited[num]) {
                // don't visit
                continue;
            } else {
                visited[num] = true;
                dfs(graph, visited, num);
            }
        }
    }
}