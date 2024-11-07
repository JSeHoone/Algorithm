import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String stringInt = Integer.toString(n);
        
        for (int i = 0; i < stringInt.length(); i++) {
            char number = stringInt.charAt(i);
            answer += Character.getNumericValue(number);
        }

        return answer;
    }
}