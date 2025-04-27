import java.io.*;

public class Main {
    static int N, M;
    static int[] output;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        N = Integer.parseInt(in[0]);
        M = Integer.parseInt(in[1]);

        output = new int[M];
        StringBuilder sb = new StringBuilder();
        dfs(0, sb);
        System.out.print(sb);
    }

    static void dfs(int depth, StringBuilder sb) {
        if (depth == M) {
            for (int x : output) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            output[depth] = i;
            dfs(depth + 1, sb);
        }
    }
}
