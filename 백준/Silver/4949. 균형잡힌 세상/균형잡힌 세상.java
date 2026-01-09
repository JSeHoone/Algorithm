/*
종료 조건이 첫 시작이 온점(.)이면 종료된다.
StringTokenizer를 사용하면 되나 ?

괄호를 저장하는 구조는 Stack으로 관리
*/

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        while (true) {
            // 한 줄 마다 String 가져옴
            String line = br.readLine();
            char[] st = line.toCharArray();
            
            // 마지막에 .이 오면 멈추도록
            if (line.equals(".")) {
                break;
            }
            
            // 글자 하나씩 돌면서 확인
            for (int i = 0; i < line.length(); i++) {
                char token = st[i];
            
                // 여는 괄호는 무조건 push
                if (token == '(' || token == '[') {
                    stack.addLast(token);
                }
                // 닫는 괄호 처리
                else if (token == ')' || token == ']') {
                    // 닫는 괄호인데 스택이 비어 있으면 바로 실패
                    if (stack.isEmpty()) {
                        stack.add('#');   // 실패 표시용 더미
                        break;
                    }
            
                    char top = stack.peekLast();
            
                    // 타입이 맞으면 pop
                    if ((top == '(' && token == ')') ||
                        (top == '[' && token == ']')) {
                        stack.pollLast();
                    } 
                    // 타입이 다르면 바로 실패
                    else {
                        stack.add('#');   // 실패 표시
                        break;
                    }
                }
            }


            // stack 확인
            if (stack.size() == 0) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
            
            // stack 초기화
            stack.clear();
        }
        
        System.out.println(sb);
    }
}