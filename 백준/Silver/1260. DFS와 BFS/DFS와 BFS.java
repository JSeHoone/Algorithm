import java.io.*;
import java.util.*;

public class Main {
    private int V;
    private LinkedList<Integer>[] adj;
    
    public void makeGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }
    
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }
    
    public void DFS(int s) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        
        while (!stack.isEmpty()) {
            int current = stack.pop();
            
            if (!visited[current]) {
                visited[current] = true;
                System.out.print((current + 1) + " "); 
                

                List<Integer> neighbors = new ArrayList<>(adj[current]);
                Collections.sort(neighbors);

                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    int neighbor = neighbors.get(i);
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }
    

    public void BFS(int s) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        
        visited[s] = true;
        queue.add(s);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print((current + 1) + " "); 
            
            List<Integer> neighbors = new ArrayList<>(adj[current]);
            Collections.sort(neighbors);
            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]); 
        int m = Integer.parseInt(firstLine[1]); 
        int start = Integer.parseInt(firstLine[2]); 
        
        Main graph = new Main();
        graph.makeGraph(n);
        

        for (int i = 0; i < m; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]) - 1;
            int v = Integer.parseInt(edge[1]) - 1;
            graph.addEdge(u, v);
        }
        

        int startIndex = start - 1;
        

        graph.DFS(startIndex);
        System.out.println();
        graph.BFS(startIndex);
    }
}
