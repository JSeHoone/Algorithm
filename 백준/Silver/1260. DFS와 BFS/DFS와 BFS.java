import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int nodeNum = Integer.parseInt(inputs[0]);
        int edgeNum = Integer.parseInt(inputs[1]);
        int startNum = Integer.parseInt(inputs[2]);

        // graph
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // set nodes
        for (int i = 1; i < nodeNum+1; i++) {
            graph.put(i, new ArrayList<>());
        }

        // set Edge
        for (int i = 0; i < edgeNum; i++) {
            String[] nodes = br.readLine().split(" ");
            int node1 = Integer.parseInt(nodes[0]);
            int node2 = Integer.parseInt(nodes[1]);

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        // DFS
        StringBuilder sb = new StringBuilder();
        Set<Integer> visited = new HashSet<>();
        dfs(startNum, graph, visited, sb);
        System.out.println(sb);

        // BFS
        System.out.println(bfs(startNum, graph));
    }

    public static String bfs(int start, Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(start);

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            Integer nodeValue = q.poll();
            if (visited.contains(nodeValue)) continue;

            visited.add(nodeValue);

            List<Integer> edgeNodes = graph.get(nodeValue);
            Collections.sort(edgeNodes);

            for (int edgeNode : edgeNodes) {
                if (!visited.contains(edgeNode)) {
                    q.offer(edgeNode);
                }
            }

            sb.append(nodeValue).append(" ");
        }

        return sb.toString();
    }

    public static void dfs(int currentNode, Map<Integer, List<Integer>> graph, Set<Integer> visited, StringBuilder sb) {
        if (visited.contains(currentNode)) return;

        visited.add(currentNode);
        sb.append(currentNode).append(" ");

        List<Integer> edgeNodes = graph.get(currentNode);
        Collections.sort(edgeNodes);

        for (int nextNode : edgeNodes) {
            dfs(nextNode, graph, visited, sb);
        }


    }
}