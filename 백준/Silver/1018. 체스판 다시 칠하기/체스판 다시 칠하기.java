import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int M = input[1];

        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            board[i] = row;
        }

        int min = Integer.MAX_VALUE;
        for (int row = 0; row < N-7; row++) {
            for (int col = 0; col < M-7; col++) {
                int case1 = 0;
                int case2 = 0;

                for (int a = row; a < row+8; a++) {
                    for (int b = col; b < col+8; b++) {
                        // check logic
                        if ( (a+b) % 2 == 0) {
                            if (board[a][b] !='W') {
                                case1++;
                            }
                            if (board[a][b] != 'B') {
                                case2++;
                            }
                        } else {
                            if (board[a][b] !='B') {
                                case1++;
                            }
                            if (board[a][b] != 'W') {
                                case2++;
                            }
                        }
                    }
                }
                int caseMin = Math.min(case1, case2);
                if (min > caseMin) {
                    min = caseMin;
                }

            }
        }

        System.out.println(min);


    }
}
