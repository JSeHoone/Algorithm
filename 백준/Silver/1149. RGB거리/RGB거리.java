import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // [red, green, blue]의 코스트 저장
        int[] cost = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 1; i < N; i++) {
            int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // 색상 마다 선택
            int red = Math.min(cost[1], cost[2]) + row[0];
            int green = Math.min(cost[0], cost[2]) + row[1];
            int blue = Math.min(cost[0], cost[1]) + row[2];

            cost[0] = red;
            cost[1] = green;
            cost[2] = blue;
        }

        System.out.print(Arrays.stream(cost).min().getAsInt());
    }


}
