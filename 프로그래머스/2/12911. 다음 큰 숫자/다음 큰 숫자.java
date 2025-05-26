import java.lang.Integer;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int countN = Integer.bitCount(n);
        
        boolean flag = true;
        while (flag) {
            int target = ++n;
            int countTarget = Integer.bitCount(target);
            
            if (countN == countTarget) {
                answer = target;
                flag = false;
                break;
            }
        }
        
        return answer;
    }
}