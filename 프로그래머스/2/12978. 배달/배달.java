import java.util.*;

class Solution {
    Map<Integer, List<int[]>> graph;
    int[] dist; 
    
    public int solution(int N, int[][] road, int K) {

        graph = new HashMap<>();
        for (int[] edge : road) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }


        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0; 


        dfs(1, 0);


        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }
        return answer;
    }

    private void dfs(int node, int currentCost) {

        for (int[] next : graph.getOrDefault(node, Collections.emptyList())) {
            int nextNode = next[0];
            int nextCost = currentCost + next[1];


            if (nextCost < dist[nextNode]) {
                dist[nextNode] = nextCost;
                dfs(nextNode, nextCost);
            }
        }
    }
}
