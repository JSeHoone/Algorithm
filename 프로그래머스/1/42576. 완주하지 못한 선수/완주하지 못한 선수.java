import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            String person = participant[i];
            map.put(person, map.getOrDefault(person, 0) + 1);
        }
        
        for (String person : completion) {
            map.put(person, map.get(person) - 1);
        }
        
        for (String key : map.keySet()) {
            int remain = map.get(key);
            if (remain == 1) {
                answer = key;
                break;
            }
        }
        return answer;
    }
}