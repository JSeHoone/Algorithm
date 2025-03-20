import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] temp;
        List<Integer> answer = new ArrayList<>();
        for (int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];
            
            temp = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(temp);
            answer.add(temp[k-1]);
        }
        
        
        return answer.stream().mapToInt(i -> i).toArray(); 
    }
}