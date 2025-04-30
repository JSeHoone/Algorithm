import java.io.*;
import java.util.*;

public class Main{
    private static Stack stack;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        stack = new Stack();
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int[] commands = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (commands.length == 1) {
                stackCommand(commands[0], 0);
            } else {
                stackCommand(commands[0], commands[1]);
            }
        }

        System.out.print(sb);
    }

    private static void stackCommand(int command, int value) {
        switch (command) {
            case 1: 
                stack.push(value);
                break;
            case 2: 
                if (stack.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(stack.pop()).append("\n");
                }
                break;
            case 3: 
                sb.append(stack.size()).append("\n");
                break;
            case 4: 
                sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                break;
            case 5:
                if (stack.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(stack.peek()).append("\n");
                }
                break;
        }
    }
}