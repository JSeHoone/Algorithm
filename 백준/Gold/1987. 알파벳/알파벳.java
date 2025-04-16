import java.io.*;
import java.util.*;

public class Main {
    private static int R, C;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int max = 0;
    private static char[][] board;
    private static boolean[] visited = new boolean[26]; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        dfs(0, 0, 1);
        System.out.println(max);
    }

    public static void dfs(int x, int y, int count) {
        visited[board[x][y] - 'A'] = true;
        max = Math.max(max, count);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                char next = board[nx][ny];
                if (!visited[next - 'A']) {
                    dfs(nx, ny, count + 1);
                    visited[next - 'A'] = false;
                }
            }
        }
    }
}
