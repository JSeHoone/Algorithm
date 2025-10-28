import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] numberArray = new int[N];

        for (int i = 0; i < N; i++) {
            numberArray[i] = i + 1;
        }

        for (int i = 0; i < M; i++) {
            int[] number = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int indexA = number[0] - 1;
            int valueA = numberArray[indexA];
            int indexB = number[1] - 1;
            int valueB = numberArray[indexB];
            numberArray[indexA] = valueB;
            numberArray[indexB] = valueA;
        }

        for (int unit : numberArray) {
            System.out.print(unit + " ");
        }



    }
}
