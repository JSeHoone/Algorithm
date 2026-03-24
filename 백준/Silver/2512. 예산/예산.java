import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] budgets = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(br.readLine());

        // 예산 정렬하기
        Arrays.sort(budgets);

        // 예산을 다 배정해줄 수 있는 경우
        int sum = Arrays.stream(budgets).sum();
        if (sum <= target) {
            System.out.println(budgets[N-1]);
        } else {
            // 최대한 나눠줘야 함.
            long lo = 0;
            long hi = budgets[N-1];
            long answer = 0;
            
            while (lo <= hi) {
                long mid = lo + (hi - lo) / 2;

                if (check(mid, target, budgets)) {
                    answer = mid;
                    lo = mid + 1;
                } else {
                    hi = mid -1;
                }
            }
            System.out.println(answer);
        }
    }

    private static boolean check(long mid, long target, int[] budgets) {
        long sum = 0;
        for (int budget : budgets) {
            if (budget > mid) {
                sum += mid;
            } else {
                sum += budget;
            }
        }

        return sum <= target;
    }
}