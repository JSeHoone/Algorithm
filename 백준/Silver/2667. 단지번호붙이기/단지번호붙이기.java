import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int[][] board;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int count;
    private static List<Integer> countries = new ArrayList<>();
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            int[] row = new int[N];
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                row[j] = line.charAt(j) - '0';
            }
            board[i] = row;
        }


        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (board[y][x] == 1) {
                    bfs(x,y);
                    count++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");

        // 오름차순 정렬
        Collections.sort(countries);
        for (int country : countries) {
            sb.append(country).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int row, int col) {

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{row,col});
        board[col][row] = 0;

        int country = 1;

        while(!q.isEmpty()) {
            int[] position = q.pollFirst();
            int x = position[0];
            int y = position[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if (board[ny][nx] == 1) {
                    board[ny][nx] = 0;
                    q.add(new int[]{nx, ny});
                    country++;
                }
                
            }
        }

        countries.add(country);
    }

    
}