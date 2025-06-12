import java.util.*;

class Solution {
    class Edge {
        int to;
        int cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        // make graph
        List<Edge>[] graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // make edge
        for (int[] fare : fares) {
            int u = fare[0], v = fare[1], w = fare[2];
            graph[u].add(new Edge(v,w));
            graph[v].add(new Edge(u,w));
        }
        
        // dijkstra
        int[] distFromS = dijkstra(n, graph, s);
        int[] distFromA = dijkstra(n, graph, a);
        int[] distFromB = dijkstra(n, graph, b);

        answer = Integer.MAX_VALUE;
        for (int t = 1; t <= n; t++) {
            if (distFromS[t] == Integer.MAX_VALUE ||
                distFromA[t] == Integer.MAX_VALUE ||
                distFromB[t] == Integer.MAX_VALUE)
                continue;
            answer = Math.min(answer, distFromS[t] + distFromA[t] + distFromB[t]);
        }
        return answer;
    }
    
    
    private int[] dijkstra(int n, List<Edge>[] graph, int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        dist[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (cur.cost > dist[cur.to]) continue;

            for (Edge next : graph[cur.to]) {
                int newCost = cur.cost + next.cost;
                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.add(new Edge(next.to, newCost));
                }
            }
        }
        return dist;
    }
}