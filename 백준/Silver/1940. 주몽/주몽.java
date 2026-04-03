import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[] items = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // sort
        Arrays.sort(items);

        // two pointer
        int leftPointer = 0;
        int rightPointer = N-1;

        int answer = 0;
        while (leftPointer != rightPointer) {
            int sumItem = items[leftPointer] + items[rightPointer];

            if (target == sumItem) {
                answer++;
                leftPointer++;
            } else if (target > sumItem) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }

        System.out.println(answer);
    }
}