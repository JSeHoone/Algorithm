class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        String convertToStringN = Long.toString(n, k);
        String[] splitZeroList = convertToStringN.split("0");

        for (String stringNum : splitZeroList) {
            if (stringNum.isEmpty()) continue; 
            long num = Long.parseLong(stringNum);
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }

    public static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
