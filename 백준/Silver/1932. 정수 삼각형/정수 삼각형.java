import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N][N];
        // 시작 채우기
        int start = Integer.parseInt(br.readLine());
        dp[0][0] = start;

        for (int i = 1; i < N; i++) {
            int[] nextLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < nextLine.length; j++) {
                if (j-1 < 0) {
                    dp[i][j] = dp[i-1][j] + nextLine[j];
                } else {
                    int num1 = dp[i-1][j] + nextLine[j];
                    int num2 = dp[i-1][j-1] + nextLine[j];
                    int maxNum =
                    dp[i][j] = Math.max(num1,num2);
                }
            }
        }

        int answer = Arrays.stream(dp[N-1]).max().getAsInt();
        System.out.println(answer);

    }


}
