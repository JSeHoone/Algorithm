import java.util.ArrayList;

class Solution {
    ArrayList<int[]> rootArray = new ArrayList<>();
    
    public int[][] solution(int n) {
        // 1번 막대에서 3번 막대로, 2번 막대를 거쳐서
        hanoiFunction(n, 1, 3, 2);
        return rootArray.toArray(new int[rootArray.size()][]);
    }
    
    public void hanoiFunction(int n, int start, int end, int via) {
        if (n == 1) {
            rootArray.add(moveFunction(1, start, end));
        } else {
            hanoiFunction(n - 1, start, via, end);
            rootArray.add(moveFunction(n, start, end));
            hanoiFunction(n - 1, via, end, start);
        }
    }
    
    public int[] moveFunction(int n, int start, int end) {
        return new int[]{start, end};
    }
}
