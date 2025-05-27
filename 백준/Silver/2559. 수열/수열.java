import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        
        int[] days = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int cumSum = 0;
        for (int i = 0; i < K; i++) {
            cumSum += days[i];
        }

        int answer = cumSum;

        for (int i = K; i < N; i++) {
            cumSum = cumSum - days[i - K] + days[i];
            answer = Math.max(answer, cumSum);
        }
        
        System.out.print(answer);
    }
}
