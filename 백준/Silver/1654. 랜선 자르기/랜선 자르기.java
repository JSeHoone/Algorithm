import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = data[0];
        int target = data[1];

        int[] lans = new int[N];
        for (int i = 0; i < N; i++) {
            lans[i] = Integer.parseInt(br.readLine());
        }

        // sort 
        Arrays.sort(lans);

        // logic
        long lo = 1;
        long hi = lans[N-1];
        long answer =0;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;

            if (check(mid, lans, target)) {
                answer = mid;
                lo = mid + 1;
            } else{
                hi = mid - 1;
            }
        }

        System.out.println(answer);
        
    }

    // check
    public static boolean check(long mid, int[] lans, int target) {
        long sum = 0;
        for (int lan : lans) {
            sum += (lan / mid);
        }

        return sum >= target;
    }
}