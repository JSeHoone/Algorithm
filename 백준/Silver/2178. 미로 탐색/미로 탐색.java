import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int M;
    private static int count;
    private static int[][] board;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            int[] row = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            board[i] = row;
        }

        bfs();
        System.out.println(board[N-1][M-1]);

    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});

        while (!q.isEmpty()) {
            int[] current = q.poll();

            if (board[current[0]][current[1]] != 0) {

                for (int i =0; i < 4; i++) {
                    int nx = current[0] + dx[i];
                    int ny = current[1] + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        continue;
                    }
                    if (board[nx][ny] == 1) {
                        board[nx][ny] = board[current[0]][current[1]] + 1;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
    }

}
