import java.io.*;
import java.util.*;

public class Main {
    private static int[][] map;
    private static int x,y;
    private static int[] dy = {-1,1,0,0};
    private static int[] dx = {0,0,-1,1};
    private static int day = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] position = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        y = position[0];
        x = position[1];

        map = new int[x][y];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < x; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[i] = line;

            for (int j = 0 ; j < y; j++) {
                if (line[j] == 1) {
                    q.add(new int[]{i,j});
                }
            }
        }


        Queue<int[]> next = bfs(q);

        while (!next.isEmpty()) {
            next = bfs(next);
            day++;
        }

        // map안에 0이 있으면 -1을 반환해야함.
        if (remainedTomato()) {
            System.out.println(-1);
        } else {
            System.out.println(day);
        }



    }

    private static Queue<int[]> bfs(Queue<int[]> q) {
        Queue<int[]> result = new LinkedList<>();

        while (!q.isEmpty()) {
            int[] position = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = position[0] + dy[i];
                int nx = position[1] + dx[i];
                int[] next = new int[]{ny,nx};

                if (ny < 0 || ny > map.length - 1 || nx < 0 || nx > map[0].length - 1) {
                    continue;
                }

                if (map[ny][nx] == 0) {
                    result.add(new int[]{ny,nx});
                    map[ny][nx] = 1;
                }

            }
        }

        return result;
    }

    private static boolean remainedTomato() {
        for (int[] row : map) {
            for (int unit : row ) {
                if (unit == 0) {
                    return true;
                }
            }
        }

        return false;
    }

}
