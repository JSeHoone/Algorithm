import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        int index = 0;
        for (int i=0; i < 10; i++) {
            String product = discount[i];
            
            if (map.containsKey(product)) {
                map.put(product, map.get(product)-1);
            }
            index++;
        }
        
        // check
        boolean check = checkWant(map);
        if (check) {
            answer++;
        }
        
        // while
        while (index != discount.length) {
            String preProduct = discount[index-10];
            String nextProduct = discount[index];
            
            if (map.containsKey(preProduct)) {
                map.put(preProduct, map.get(preProduct) + 1);
            }
            
            if (map.containsKey(nextProduct)) {
                map.put(nextProduct, map.get(nextProduct) - 1);
            }
            
            if (checkWant(map)) {
                answer++;
            }
            
            index++;
            
        }
        
        return answer;
    }
    
    private boolean checkWant(Map<String, Integer> map) {
        for (Integer want : map.values()) {
            if (want > 0) {
                return false;
            }
        }
        
        return true;
    }
    
}