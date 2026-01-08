/*
Stack으로 접근하면 될 것 같음
*/

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        // Stack 생성
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String inputData = br.readLine();
            
            for (char data : inputData.toCharArray()) {
                Character peekData = stack.peekLast();
                if (peekData == null) {
                    stack.add(data);
                } else {
                    if (peekData == '(' && data == ')') {
                        stack.pollLast();
                    } else {
                        stack.add(data);
                    }
                }
            }
            
            if (stack.size() == 0) {
                sb.append("YES").append("\n");
            } else {;
                sb.append("NO").append("\n");
            }
            
            // stack 초기화
            stack.clear();
        }

        System.out.println(sb);
    }
};