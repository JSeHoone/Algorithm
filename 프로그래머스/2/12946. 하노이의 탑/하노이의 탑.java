class Solution {
    private int index = 0;
    
    public int[][] solution(int n) {
        int[][] answer = new int[(int) Math.pow(2,n) -1][2];
        
        move(n, 1, 3, 2, answer);
        
        return answer;
    }
    
    public void move(int n, int start, int end, int via, int[][] answer) {
        if (n == 1) {
            answer[index++] = new int[]{start, end};
            return ;
        } else {
            move(n-1, start, via, end, answer);
            answer[index++] = new int[]{start,end};
            move(n-1,via, end, start, answer);
        }
    }
}