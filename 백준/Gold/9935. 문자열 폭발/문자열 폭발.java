import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(); 
        String bomb = br.readLine();
        int bombLen = bomb.length();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));

            if (stack.size() >= bombLen) {
                boolean match = true;

                for (int j = 0; j < bombLen; j++) {
                    if (stack.get(stack.size() - bombLen + j) != bomb.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    for (int j = 0; j < bombLen; j++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (char ch : stack) {
                sb.append(ch);
            }
            System.out.println(sb);
        }
    }
}
