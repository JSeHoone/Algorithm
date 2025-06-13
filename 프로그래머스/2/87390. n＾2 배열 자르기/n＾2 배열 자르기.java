class Solution {
    public int[] solution(int n, long left, long right) {
        int length = (int)(right - left + 1);
        int[] answer = new int[length];
        
        for (int idx = 0; idx < length; idx++) {
            long num = left + idx;
            int row = (int)(num / n);  
            int col = (int)(num % n);  
            answer[idx] = Math.max(row, col) + 1;
        }
        return answer;
    }
}
