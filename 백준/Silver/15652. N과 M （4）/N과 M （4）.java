import java.io.*;

public class Main {
    private static int N;
    private static int M;
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        visited = new int[M];

        StringBuilder sb = new StringBuilder();
        dfs(0, sb);
        System.out.println(sb);
    }

    public static void dfs(int depth, StringBuilder sb) {
        if (depth == M) {
            for (int x : visited) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i<=N; i++) {
            if (M > 1 && depth > 0) {
                if (visited[depth-1] > i) {
                    continue;
                }
            }
            visited[depth] = i;
            dfs(depth + 1, sb);
        }
    }
}
