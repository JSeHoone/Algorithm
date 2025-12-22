/*
생각나는 풀이 방법
1. 스택 자료구조를 이용한다. 
2. 스택의 peek()를 이용해서 `()`를 판별한다.

*/

import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char value : s.toCharArray()) {
            Character peekValue = stack.peek();
            
            if (peekValue == null || peekValue == ')') {
                stack.push(value);
                continue;
            } 
            
            if (value == ')') {
                stack.pop();
            } else {
                stack.push(value);
            }
            
        }
        
        if (stack.size() == 0) {
            return true;
        }
        
        return false;
    }
}