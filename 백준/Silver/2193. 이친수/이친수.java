import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] pinary = new long[N+1];
        pinary[0] = 0; pinary[1] = 1;

        for (int i = 2; i <= N; i++) {
            pinary[i] = pinary[i-2] + pinary[i-1];
        }

        System.out.println(pinary[N]);
    }


}
