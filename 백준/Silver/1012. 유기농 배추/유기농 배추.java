import java.util.*;
import java.io.*;

public class Main{
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int M,N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {
            String[] info = br.readLine().split(" ");
            M = Integer.parseInt(info[0]);
            N = Integer.parseInt(info[1]);
            
            int count = Integer.parseInt(info[2]);
            
            
            boolean[][] cabbageField = new boolean[N][M];

            // create Field
            for (int j = 0; j < count; j++) {
                int[] position = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                cabbageField[position[1]][position[0]] = true;
            }

            // check cabbage
            int wormCount = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (cabbageField[y][x] == true) {
                        bfs(cabbageField, x, y);
                        wormCount++;
                    }
                }
            }

            System.out.println(wormCount);

        }
    }

    private static void bfs(boolean[][] field, int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});
        field[y][x] = false;

        while(!q.isEmpty()) {
            int[] position = q.pollFirst();
            int positionX = position[0];
            int positionY = position[1];

            for (int i = 0; i < 4; i++) {
                int nx = positionX + dx[i];
                int ny = positionY + dy[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                    continue;
                }

                if (field[ny][nx] == true) {
                    field[ny][nx] = false;
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }
}