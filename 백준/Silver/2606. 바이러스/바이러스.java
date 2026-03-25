import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static int N;
    private static int links;
    private static Map<Integer,List<Integer>> graph;
    private static boolean[] visited;
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 그래프 노드를 만들 때 사용
        N = Integer.parseInt(br.readLine());
        // 엣지를 연결할 때 사용
        links = Integer.parseInt(br.readLine());

        // make graph
        graph = new HashMap<>();
        
        for (int i = 1; i < N+1; i++) {
            List<Integer> newList = new LinkedList<>();
            graph.put(i,newList);
        }

        // link node
        for (int i = 0; i < links; i++) {
            // node1, node2 둘다 연결해줘야 함.
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        visited = new boolean[N+1];
        // bfs
        int answer = bfs(1);
        System.out.println(answer);
    }

    private static int bfs(int startNode) {

        Deque<List<Integer>> q = new ArrayDeque<>();
        q.add(graph.get(startNode));
        visited[startNode] = true;

        int result = 0;

        while(!q.isEmpty()) {
            List<Integer> computers = q.pop();

            for (int computer : computers) {
                if (!visited[computer]) {
                    visited[computer] = true;
                    result++;
                } else {
                    continue;
                }

                q.add(graph.get(computer));
            }
            
        }

        return result;


        
    }
}