import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        // 앞뒤 {{ }} 제거
        s = s.substring(2, s.length() - 2);
        String[] tupleStrings = s.split("\\},\\{");

        List<int[]> result = new ArrayList<>();
        for (String tuple : tupleStrings) {
            String[] nums = tuple.split(",");
            int[] arr = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                arr[i] = Integer.parseInt(nums[i]);
            }
            result.add(arr);
        }

        // 내부 배열 길이를 기준으로 오름차순 정렬
        result.sort(Comparator.comparingInt(arr -> arr.length));
        
        int N = result.get(result.size() -1).length;
        int[] answer = new int[N];
        int index = 0;
        for (int[] arr : result) {
            for (int x : arr) {
                if (!Arrays.stream(answer).anyMatch(i -> i == x)) {
                    answer[index] = x;
                    index++;
                }
            }
        }
    
        
        return answer;
    }
}