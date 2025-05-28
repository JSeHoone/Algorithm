import java.io.*;
import java.util.*;

public class Main {
    private static int recursiveCount = 0;
    private static int dynamicCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        recursiveCount++;
        fib(N);

        fibonacci(N);

        System.out.print(recursiveCount + " " + dynamicCount);
    }

    private static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            recursiveCount++;
            return fib(n-1) + fib(n-2);
        }
    }

    private static int fibonacci(int n) {
        int[] f = new int[n + 1];
        f[1] = f[2] = 1;

        for (int i = 3; i <= n; i++) {
            f[i] = f[i-1] + f[i-2];
            dynamicCount++;
        }

        return f[n];
    }
}
