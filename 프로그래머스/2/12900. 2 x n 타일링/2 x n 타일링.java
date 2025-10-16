/*
바닥의 크기가 2 * n인 곳에 (2,1) 타일을 가득 채우는 방법

예시) n = 4 일 때
2,2
1,1,1,1
2,1,1
1,1,2
1,2,1

5가지가 있음

n = 1 -> 1;
n = 2 -> 2;
n = 3 -> 3;
n = 4 -> 5;
n = 5 -> 8;
13, 21, 34, 55, 89
n = n-2 + n-1;

*/


class Solution {
    static final long MOD = 1_000_000_007L;

    public int solution(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD; 
        }
        return (int)(dp[n] % MOD);
    }
}
