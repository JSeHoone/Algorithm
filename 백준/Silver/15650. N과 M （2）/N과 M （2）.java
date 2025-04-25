import java.io.*;
import java.util.Arrays;

public class Main {
    private static int N;
    private static int M;
    private static int[] array;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        array = new int[N];
        int number = 1;
        for (int i = 0; i < N; i++) {
            array[i] = number;
            number++;
        }
        visited = new boolean[N];
        StringBuilder sb = new StringBuilder();
        dfs(0,0, sb);
        System.out.println(sb);
    }

    static void dfs(int start, int depth, StringBuilder sb) {
        if (depth == M) {
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    sb.append(array[i]).append(" ");
                }
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;          
            dfs(i + 1, depth + 1, sb);      
            visited[i] = false;
        }
    }
}