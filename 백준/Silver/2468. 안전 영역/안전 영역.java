import java.io.*;
import java.util.*;

public class Main {
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static int N;
    private static int[][] board;
    private static int maxHeight, maxArea;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int maxRow = Arrays.stream(row).max().getAsInt();
            maxHeight = Math.max(maxHeight, maxRow);
            board[i] = row;
        }

       // 높이 0부터 maxHeight까지 안전 구역 갯수 계산
       for (int h = 0; h <= maxHeight; h++) {
           maxArea = Math.max(maxArea, countSafeAreas(h));
       }
        System.out.println(maxArea);
    }

    private static int countSafeAreas(int h) {
        boolean[][] visited = new boolean[N][N];
        Deque<int[]> q = new ArrayDeque<>();
        int areaCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 물에 잠기지 않고, 아직 방문하지 않은 곳이면
                if (!visited[i][j] && board[i][j] > h) {
                    areaCount++;
                    visited[i][j] = true;
                    q.clear();
                    q.offer(new int[]{i,j});
                }

                while (!q.isEmpty()) {
                    int[] current = q.poll();
                    int x = current[0], y = current[1];

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = x + dx[dir], ny = y + dy[dir];

                        if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && board[nx][ny] > h) {
                            visited[nx][ny] = true;
                            q.offer(new int[]{nx,ny});
                        }
                    }
                }
            }
        }
        return areaCount;
    }
}
