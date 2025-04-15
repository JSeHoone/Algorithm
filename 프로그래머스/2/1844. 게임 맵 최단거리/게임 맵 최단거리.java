import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    
    public int solution(int[][] maps) {
        bfs(maps, 0,0);
        
        int targetPointX = maps.length - 1;
        int targetPointY = maps[0].length - 1;
        
        if (maps[targetPointX][targetPointY] == 1){
            return -1;
        } else {
            return maps[targetPointX][targetPointY];
        }
    }
    
    public void bfs(int[][] maps, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        
        while (!queue.isEmpty()) {
            int[] position  = queue.poll();
            int x = position[0];
            int y = position[1];
            
            // 상하좌우
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length) {
                    continue;
                }
                
                if (maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[x][y] + 1;
                    queue.offer(new int[]{nx,ny});
                }
            }
        }
    }
}