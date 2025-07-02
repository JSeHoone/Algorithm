import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int C;
    private static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        // 정렬
        Arrays.sort(arr);

        long start = 1, end = arr[N - 1] - arr[0];
        long ans = 0;

        while (start <= end) {
            long mid = (start + end) / 2;

            if (isPossible(mid)) {
                ans = mid;         
                start = mid + 1;
            } else {
                end = mid - 1;     
            }
        }

        System.out.println(ans);
    }

    public static boolean isPossible(long distance) {
        long count = 1;
        long last = arr[0];

        for (int i = 1; i < N; i++) {
            if (arr[i] - last >= distance) {
                count++;
                last = arr[i];
            }
        }

        return count >= C;
    }
}
