import java.io.*;
import java.util.*;

public class Main {
    private static int[][] map;
    private static int x,y;
    private static int[] dy = {-1,1,0,0};
    private static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] position = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        y = position[0];
        x = position[1];

        map = new int[y][x];
        for (int i = 0; i < y; i++) {
            String line = br.readLine();
            for (int j = 0; j < x; j++) {
                String token = String.valueOf(line.charAt(j));
                map[i][j] = Integer.parseInt(token);
            }
        }

        bfs();
        System.out.println(map[y-1][x-1]);

    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});

        while (!q.isEmpty()) {
            int[] position = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = position[0] + dy[i];
                int nx = position[1] + dx[i];

                if (ny < 0 || ny > map.length - 1 || nx < 0 || nx > map[0].length - 1) {
                    continue;
                }

                if (map[ny][nx] == 1) {
                    q.add(new int[]{ny,nx});
                    map[ny][nx] = map[position[0]][position[1]] + 1;
                }

            }
        }
    }

}
