
import java.util.*;

class Solution {

    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> sizeMap = new HashMap<>();

        for (int size : tangerine) {
            sizeMap.merge(size, 1, Integer::sum); 
        }

        List<Integer> sizeCounts = new ArrayList<>(sizeMap.values());
        sizeCounts.sort(Comparator.reverseOrder()); 

        for (int count : sizeCounts) {
            k -= count;
            answer++;              
            if (k <= 0) break;     
        }

        return answer;
    }
}