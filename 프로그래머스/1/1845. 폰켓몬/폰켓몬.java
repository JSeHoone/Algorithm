import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashMap<Integer, Integer> dict = new HashMap<>();
        
        for (int num : nums) {
            if (!dict.containsKey(num)) {
                dict.put(num, 1);
            } else {
                dict.put(num, dict.get(num) + 1);
            }
        }
        
        int getPoketmon = (int) nums.length / 2;
        
        for (Integer key : dict.keySet()) {
            answer++;
            
            if (answer >= getPoketmon) {
                break;
            }
        }
        
        return answer;
    }
}