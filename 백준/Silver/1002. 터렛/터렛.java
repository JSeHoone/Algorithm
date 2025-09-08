import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] lee = new int[]{input[0],input[1], input[2]};
            int[] jo = new int[]{input[3],input[4], input[5]};

            int ryu = checkCondition(lee, jo);
            sb.append(ryu + "\n");
        }
        System.out.println(sb);
    }

    private static int checkCondition(int[] a, int[] b) {
        long x1 = a[0], y1 = a[1], r1 = a[2];
        long x2 = b[0], y2 = b[1], r2 = b[2];

        long dx = x1 - x2;
        long dy = y1 - y2;
        long d2 = dx*dx + dy*dy;
        long sum = r1 + r2;
        long diff = Math.abs(r1 - r2);
        long sum2 = sum * sum;
        long diff2 = diff * diff;

        // 1) 동심
        if (d2 == 0) {
            if (r1 == r2) return -1;        
            else return 0;
        }

        // 2) 외접/내접
        if (d2 == sum2 || d2 == diff2) return 1;

        // 3) 두 점에서 만남
        if (diff2 < d2 && d2 < sum2) return 2;

        // 4) 그 외
        return 0;
    }



}
