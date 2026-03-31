import java.util.*;
import java.io.*;

/*
X에 3가지 연산을 사용할 수 있다.
1. X가 3으로 나눠지면 3으로 나눈다.
2. X가 2로 나눠지면 2로 나눈다.
3. 1을 뺀다.

정수 N이 주어지면 위 연산 3가지를 적절하게 사용해서 1을 만든다. 
연산에 사용되는 횟수는 최소 !
*/

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        for (int i=2; i <= N; i++) {
            dp[i] = dp[i-1] + 1;

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            } 
        }

        System.out.println(dp[N]);
    }
}