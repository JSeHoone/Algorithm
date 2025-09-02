import java.lang.Math;
import java.util.Arrays;

class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int N = land.length;
        
        int[] dp = land[0];
        for (int i = 1; i < N; i++) {
            int[] row = land[i];
            
            int one = Math.max(Math.max(dp[1],dp[2]),dp[3])+ row[0];
            int two = Math.max(Math.max(dp[0],dp[2]),dp[3])+ row[1];
            int three = Math.max(Math.max(dp[0],dp[1]),dp[3])+ row[2];
            int four = Math.max(Math.max(dp[0],dp[1]),dp[2])+ row[3];
            
            dp[0] = one;
            dp[1] = two;
            dp[2] = three;
            dp[3] = four;
        }
        
        answer = Arrays.stream(dp).max().getAsInt();

        return answer;
    }
}