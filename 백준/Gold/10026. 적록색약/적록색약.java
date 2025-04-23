import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int N;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        char[][] greed= new char[N][N];

        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            greed[i] = row;
        }
        char[][] copyGreed = new char[N][N];
        for (int i = 0; i < N; i++) {
            copyGreed[i] = greed[i].clone();
        }

        // 적록색약 X
        int count1 = 0;
        for (int row1 = 0; row1 < N; row1++) {
            for (int col1 = 0; col1 < N; col1++) {
                if (greed[row1][col1] == 'A') {
                    continue;
                } else {
                    bfs(greed, row1, col1, false);
                    count1++;
                }
            }
        }

        // 적록색약 O
        int count2 = 0;
        for (int row2 =0; row2 < N; row2++) {
            for (int col2 = 0; col2 < N; col2++) {
                if (copyGreed[row2][col2] == 'A') {
                    continue;
                } else {
                    bfs(copyGreed, row2, col2, true);
                    count2++;
                }
            }
        }

        System.out.println(count1 + " " + count2);
    }

    private static void bfs(char[][] grid, int row, int col, boolean rgBlind) {
        Queue<int[]> queue = new LinkedList<>();
        char baseColor = grid[row][col];
        grid[row][col] = 'A';
        queue.add(new int[]{row, col});

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx<0||nx>=N||ny<0||ny>=N) {
                    continue;
                }

                char nextColor = grid[nx][ny];
                boolean same = (!rgBlind && (nextColor == baseColor))
                        || ( rgBlind && ((baseColor=='R'&&nextColor=='G')||(baseColor=='G'&&nextColor=='R')||nextColor==baseColor));
                if (same) {
                    grid[nx][ny] = 'A';
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

}
