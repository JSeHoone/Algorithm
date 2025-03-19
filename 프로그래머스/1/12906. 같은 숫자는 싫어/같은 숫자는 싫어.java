import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        
        int pre = -1;
        for (int num : arr) {
            if (num != pre) {
                list.add(num);
                pre = num;
            }
        }
        
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}