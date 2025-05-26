class Solution {
    int[] memo;

    public int solution(int n) {
        memo = new int[n + 1];
        return fibonacci(n);
    }

    private int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        if (memo[n] != 0) return memo[n];
        
        memo[n] = (fibonacci(n - 1) + fibonacci(n - 2)) % 1234567;
        return memo[n];
    }
}
