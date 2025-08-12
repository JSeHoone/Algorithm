import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);           

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            int cur = numbers[i];

            while (!stack.isEmpty() && stack.peek() <= cur) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                answer[i] = stack.peek();
            }

            stack.push(cur);
        }

        return answer;
    }
}
