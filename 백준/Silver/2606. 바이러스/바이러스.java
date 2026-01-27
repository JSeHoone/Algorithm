import java.util.*;
import java.io.*;

/*
첫줄에 컴퓨터 수 주어짐
두번째 줄에는 네트워크 상에 직접 연결되어있는 컴퓨터 쌍의 수가 주어짐
이어서 한 쌍씩 주어짐

1번 컴퓨터가 웜 바이러스에 걸렸을 때, 걸리게 되는 컴퓨터의 수를 출력한다.
*/

public class Main {
    private static int N,M;
    private static Map<Integer,List<Integer>> graph = new HashMap<>();
    private static int count = -1;
    private static boolean[] visited;
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N+1]; // N+1 만큼 할당해서 node번호를 맞춰줌

        // create graph
        for (int i = 0; i < M; i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if (graph.containsKey(edge[0])) {
                graph.get(edge[0]).add(edge[1]);
            } else {
                graph.put(edge[0], new ArrayList<>(List.of(edge[1])));
            }

            if (graph.containsKey(edge[1])) {
                graph.get(edge[1]).add(edge[0]);
            } else {
                graph.put(edge[1], new ArrayList<>(List.of(edge[0])));
            }
        }


        // BFS
        bfs();
        System.out.print(count);
    }

    private static void bfs() {
        // 무조건 1번 부터 시작
        Deque<Integer> q = new ArrayDeque<>();
        q.add(1);

        while(!q.isEmpty()) {
            int node = q.pollFirst();

            if(visited[node]) {
                continue;
            }
            
            // 방문 처리
            visited[node] = true;
            // 방문 컴퓨터 수 +1
            count++;
            
            List<Integer> edges = graph.get(node);
            if (edges == null) {
                continue;
            }

            for (int linkedNode : edges) {
                if (!visited[linkedNode]) {
                    q.add(linkedNode);
                }
            }
        }
    }
}