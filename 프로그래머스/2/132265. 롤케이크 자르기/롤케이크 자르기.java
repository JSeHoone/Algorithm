import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Set<Integer> ob = new HashSet<>();
        Map<Integer, Integer> yb = new HashMap<>();
        int answer = 0;

        for (int t : topping) {
            yb.put(t, yb.getOrDefault(t, 0) + 1);
        }

        for (int t : topping) {
            ob.add(t); 
            yb.put(t, yb.get(t) - 1); 
            if (yb.get(t) == 0) yb.remove(t);

            if (ob.size() == yb.size()) {
                answer++;
            }
        }

        return answer;
    }
}
