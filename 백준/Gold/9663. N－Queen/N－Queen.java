import java.io.*;


public class Main {
    private static int N;
    private static int[] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N];

        System.out.println(dfs(0));
    }

    private static int dfs(int row) {
        if (row == N) {
            return 1;
        }

        int ans = 0;
        for(int i=0; i <N; i++) {
            board[row]= i;
            if (isPossible(row)) {
                ans += dfs(row +1);
            }
        }
        return ans;

    }

    private static boolean isPossible(int row) {
        for (int i = 0; i < row; i++) {
            if (board[row] == board[i]) {
                return false;
            }

            if ((row - i) == Math.abs(board[row] - board[i])) {
                return false;
            }
        }

        return true;
    }
}
