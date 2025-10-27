import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int unit = Integer.parseInt(br.readLine());
            stack.push(unit);
        }

        int answer = 1;
        int preNum = stack.pop();
        for (int i = 0; i < N-1; i++) {
            int unit = stack.pop();
            if (unit > preNum) {
                answer++;
                preNum = unit;
            }
        }

        System.out.println(answer);

    }
}
