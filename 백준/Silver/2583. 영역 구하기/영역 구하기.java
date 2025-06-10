import java.util.*;
import java.io.*;

public class Main {
    private static int M,N,K;
    private static int[][] board;
    private static int area = 0;
    private static List<Integer> areaSize = new ArrayList<>();

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);
        board = new int[M][N];

        // fill in board
        for (int i = 0; i < K; i++) {
            int[] position = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            fillInBoard(position[0], position[1], position[2], position[3]);
        }


        for (int x = 0; x < M; x++) {
            for (int y = 0; y < N; y++) {
                bfs(x,y);
            }
        }

        areaSize.sort((a,b) -> a.compareTo(b));
        System.out.println(area);
        StringBuilder sb = new StringBuilder();
        for (int num : areaSize) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }

    private static void fillInBoard(int x1, int y1, int x2, int y2) {
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                board[j][i] = 1;
            }
        }
    }

    private static void bfs(int x, int y) {
        if (board[x][y] == 1) {
            return;
        }

        int size = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});

        while (!q.isEmpty()) {
            int[] position = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = position[0] + dx[i];
                int ny = position[1] + dy[i];
//                System.out.println(nx + " " +ny);

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                    continue;
                }

                if (board[nx][ny] == 0) {
                    int[] next = new int[]{nx, ny};
                    boolean found = q.stream().anyMatch(arr -> Arrays.equals(arr, next));
                    if (!found) {
                        q.add(next);
                    }
                }
            }
            board[position[0]][position[1]] = 1;
            size++;
        }

        area++;
        areaSize.add(size);
    }
}
