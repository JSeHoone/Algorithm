import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> uptoDays = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            double remaining = 100 - progresses[i];
            int day = (int) Math.ceil(remaining / speeds[i]);
            uptoDays.add(day);
        }
        
        List<Integer> response = new ArrayList<>();
        
        int currentDay = uptoDays.get(0);
        response.add(1);
        int count = 1;
        
        for (int i = 1; i < uptoDays.size(); i++) {
            if (uptoDays.get(i) <= currentDay) {
                response.set(response.size() - 1, response.get(response.size() - 1) + 1);
            } else {
                response.add(1);
                currentDay = uptoDays.get(i);
            }
        }
        
        return response.stream().mapToInt(Integer::intValue).toArray();
    }
}
