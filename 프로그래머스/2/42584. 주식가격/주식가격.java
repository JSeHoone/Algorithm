import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int N = prices.length;
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = i+1; j < N; j++) {
                count++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
            
            answer[i] = count;
        }
        
        
        
        
        

        return answer;
    }
}