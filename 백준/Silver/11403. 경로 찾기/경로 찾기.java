import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static LinkedList<Integer>[] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            board[i] = new LinkedList<>();
        }

        for (int i = 0; i < N; i++) {
            int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < N; j++) {
                if (row[j] == 1){
                    addEdge(i,j);
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                boolean a = dfs(row,col);
                if (a) {
                    sb.append("1 ");
                } else {
                    sb.append("0 ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    private static void addEdge(int v, int w) {
        board[v].add(w);
    }

    private static boolean dfs(int s, int e) {
        boolean[] visited = new boolean[N];
        Stack<Integer> stack = new Stack<>();

        stack.push(s);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (!visited[current]) {
                visited[current] = true;

                List<Integer> nodes = board[current];
                if (nodes.contains(e)) {
                    return true;
                }

                for (int i = nodes.size() -1; i >= 0; i--) {
                    int node = nodes.get(i);

                    if (!visited[node]) {
                        stack.push(node);
                    }
                }
            }


        }
        return false;

    }
}
