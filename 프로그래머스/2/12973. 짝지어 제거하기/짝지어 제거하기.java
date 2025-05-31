import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        
        Stack<Character> stack = new Stack<>();
        
        for (char alpha : s.toCharArray()) {
            
            if (!stack.isEmpty() && stack.peek() == alpha) {
                stack.pop();
            } else {
                stack.push(alpha);
            }
        
        } 
        
        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}