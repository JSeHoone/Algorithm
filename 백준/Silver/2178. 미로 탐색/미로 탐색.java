import java.io.*;
import java.util.*;

/*
첫째 줄에 N(y-row),M(x-col)이 주어진다.
출력 : N,M 위치로 가는 최단경로 구하기

-> BFS로 탐색해서 최소의 수를 구하기
*/
public class Main {
    private static int N,M;
    private static int[][] maze;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        // create maze
        maze = new int[N][M];
        for (int i =0; i < N; i++) {
            String input = br.readLine();

            int[] row = new int[M];
            for (int j = 0; j < M; j++) {
                char unit = input.charAt(j);
                row[j] = (int) unit - '0';
            }
            maze[i] = row;
        }

        // bfs
        bfs();

        // output
        System.out.println(maze[N-1][M-1]);
    }

    private static void bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0});

        while(!q.isEmpty()) {
            int[] position = q.pollFirst();
            int x = position[0];
            int y = position[1];

            // 현재 위치의 point
            int point = maze[y][x];
            if (maze[y][x] == 1) {
                maze[y][x] = 0;
            };

            // 상하 좌우 체크
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                    continue;
                }

                if (maze[ny][nx] == 1) {
                    q.add(new int[]{nx,ny});
                    maze[ny][nx] = point + 1;
                }
            }
        }
    }
}