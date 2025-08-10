import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int gcd = 0;

            if (numbers[0] > numbers[1]) {
                gcd = GCD(numbers[0], numbers[1]);
            } else {
                gcd = GCD(numbers[1], numbers[0]);
            }


            int lcm = numbers[0] * numbers[1] / gcd;
            System.out.println(lcm);
        }
    }

    private static int GCD(int largeNum, int smallNum) {
        int remain = 0;
        while (true) {
            remain = largeNum % smallNum;

            if (remain == 0) {
                break;
            }

            if (remain > smallNum) {
                largeNum = remain;
            } else {
                largeNum = smallNum;
                smallNum = remain;
            }
        }

        return smallNum;
    }

}
