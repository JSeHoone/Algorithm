import java.io.*;

public class Main {
    private static int N;
    private static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        System.out.println(dfs(0));
    }

    private static int dfs(int row) {
        if (row == N) {
            return 1;
        }

        int ans = 0;
        for (int col =0; col < N; col++) {
            if (isPossible(row, col)) {
                board[row][col] = 1;
                ans += dfs(row+1);
                board[row][col] = 0;
            }
        }
        return ans;

    }

    private static boolean isPossible(int row, int col) {
        for (int i =0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        int i = row -1, j = col -1;
        while (0 <= i && 0<=j) {
            if (board[i][j] == 1) {
                return false;
            }
            i -= 1;
            j -= 1;
        }

        i = (row - 1) ;
        j = (col + 1) ;

        while (0 <= i && j < N) {
            if (board[i][j] == 1) {
                return false;
            }

            i--;
            j++;
        }
        return true;
    }
}
