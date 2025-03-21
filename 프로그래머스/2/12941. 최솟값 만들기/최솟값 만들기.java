import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
    
        Arrays.sort(A);
        
        int[] reverseB = new int[B.length];
        for (int i = 0; i <B.length; i++) {
            reverseB[i] = -1 * B[i];
        }
        Arrays.sort(reverseB);
        for (int i = 0; i < reverseB.length; i++) {
            reverseB[i] = - 1*reverseB[i];
        }
        
        // check
        for (int i = 0; i < A.length; i++) {
            int mul = A[i] * reverseB[i];
            answer += mul;
        }
        

        return answer;
    }
}