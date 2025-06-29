import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] distance = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] price = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long minPrice = price[0];
        long totalCost = 0;

        for (int i = 0; i < N - 1; i++) {
            if (price[i] < minPrice) {
                minPrice = price[i];
            }
            totalCost += minPrice * distance[i];
        }

        System.out.println(totalCost);
    }
}
