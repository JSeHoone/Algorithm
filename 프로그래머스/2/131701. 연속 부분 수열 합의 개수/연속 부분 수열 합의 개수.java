import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> responseSet = new HashSet<>();
        int N = elements.length;

        for (int len = 1; len <= N; len++) { 
            for (int start = 0; start < N; start++) { 
                int sum = 0;
                for (int i = 0; i < len; i++) {
                    sum += elements[(start + i) % N]; 
                }
                responseSet.add(sum);
            }
        }

        return responseSet.size();
    }
}
