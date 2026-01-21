import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int M;
    private static int[] result;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        result = new int[M];

        backTracking(1, 0);
        System.out.println(sb);
        
    }

    private static void backTracking(int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            result[depth] = i;
            backTracking(i+1, depth+1);
        }
    }
}