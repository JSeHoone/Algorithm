class Solution {
    private final int[] dy = {-1,1,0,0};
    private final int[] dx = {0,0,-1,1};
    private int M;
    private int N;
    public int numIslands(char[][] grid) {
        int count = 0;
        M = grid.length;
        N = grid[0].length;

        for (int x = 0; x < M; x++){
            for (int y = 0; y < N; y++) {
                if (grid[x][y] == '1') {
                    int[] start = new int[]{x,y};
                    bfs(grid, start);
                    count++;
                }
            }
        }


        return count;
    }

    private void bfs(char[][] grid, int[] start) {
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        grid[start[0]][start[1]] = 0;

        while(!q.isEmpty()){
            int[] position = q.poll();
            int x = position[0];
            int y = position[1];

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                    continue;
                } 

                if (grid[nx][ny] == '1') {
                    q.add(new int[]{nx,ny});
                    grid[nx][ny] = '0';
                }
                
            }
        }
    }
}