import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] units;
    private static int[] operators = new int[4];
    private static int maxValue = Integer.MIN_VALUE;
    private static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        units = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        operators = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dfs(units[0],1);
        System.out.println(maxValue);
        System.out.println(minValue);

    }

    private static void dfs(int num, int unitIndex) {
        if (unitIndex == N) {
            maxValue = Math.max(maxValue, num);
            minValue = Math.min(minValue, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                switch (i) {
                    case 0:
                        dfs(num + units[unitIndex], unitIndex + 1);
                        break;
                    case 1:
                        dfs(num - units[unitIndex], unitIndex + 1);
                        break;
                    case 2:
                        dfs(num * units[unitIndex], unitIndex + 1);
                        break;
                    case 3:
                        dfs(num / units[unitIndex], unitIndex + 1);
                        break;
                }
                operators[i]++;
            }
        }
    }
}
