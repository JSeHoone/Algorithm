import java.util.*;
import java.lang.Math;


/*
10의 배수로 몫을 구해서 더해주는 로직

1. 더한 값을 관리하는 변수를 정의한다. (answer)
2. 지수를 관리하는 변수를 만든다. (exponent)
3. for문 안에서 n을 10^{exponent}로 나눈 몫을 answer에 더해준다. (8번만 돌면되긴 함)
*/
public class Solution {
    public int solution(int n) {
        int answer = 0;
        int numSize = (int) Math.log10(n) + 1;
        
        for (int expo = numSize-1; expo > -1; expo--) {
            int unitNum = (int) (n / (Math.pow(10, expo)));
            n = (int) (n - (Math.pow(10,expo) * unitNum));
            
            answer += unitNum;

            
        }
        
        return answer;
    }
}