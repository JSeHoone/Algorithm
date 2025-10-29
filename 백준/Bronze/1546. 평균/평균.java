import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxNum = Arrays.stream(numbers).max().getAsInt();

        List<Double> newNumbers = new ArrayList<>();
        for (int num : numbers) {
            double division = (double) num / maxNum;
            double multiple = division * 100;
            newNumbers.add(multiple);
        }

        double avg = 0.0;
        for (double num : newNumbers) {
            avg += num;
        }
        avg /= N;

        System.out.println(avg);

    }
}
