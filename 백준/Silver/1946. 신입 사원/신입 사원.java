import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // TestCase loop
        for (int i = 0; i < T; i++) {
            // Test Human number
            int N = Integer.parseInt(br.readLine());

            int[][] grades = new int[N][2];

            for (int j = 0; j < N; j++) {
                int[] human = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                grades[j] = human;
            }
            Arrays.sort(grades, (o1,o2) -> o1[0] - o2[0]);

            int count = countPassNumber(grades);
            System.out.println(count);

        }
    }

    private static int countPassNumber(int[][] grades) {
        int count = 1;
        int bestInterViewValue = grades[0][1];

        for (int[] human : grades) {
            int docValue = human[0];
            int interviewValue = human[1];

            if (interviewValue < bestInterViewValue) {
                count +=1;
                bestInterViewValue = interviewValue;
            }
        }

        return count;
    }
}
