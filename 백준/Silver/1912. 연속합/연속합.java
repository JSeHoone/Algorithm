import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numberList = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxSum = numberList[0];
        int currentSum = numberList[0];

        for (int i = 1; i < N; i++) {
            // 이전 합에 이어서 더할지, 새로 시작할지 결정
            currentSum = Math.max(numberList[i], currentSum + numberList[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);


    }
}
