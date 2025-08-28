import java.io.*;
import java.util.Arrays;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (; input[0] <= input[1]; input[0]++ ) {
            if (isPrimeNumber(input[0])) {
                System.out.println(input[0]);
            }
        }

    }

    private static boolean isPrimeNumber(int n) {
        if (n < 2) return false;
        int end = (int) Math.sqrt(n);

        for (int i = 2; i < end+1; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
