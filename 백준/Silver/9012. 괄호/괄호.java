import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            String testCase = br.readLine();

            for (char c : testCase.toCharArray()) {

                if (stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }

                if (stack.peek() == '(' && c == ')') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

    }
}
