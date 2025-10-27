import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> stack = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int unit = Integer.parseInt(br.readLine());
            stack.add(unit);
        }

        int answer = 1;
        int preNum = stack.get(N-1);
        for (int i = N-2; i > -1; i--) {
            int unit = stack.get(i);
            if (unit > preNum) {
                answer++;
                preNum = unit;
            }
        }

        System.out.println(answer);

    }
}
