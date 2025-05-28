import java.io.*;
import java.util.*;

public class Main {
    private static int[][][] memory;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        memory = new int[21][21][21];
        StringBuilder sb = new StringBuilder();
        while (true) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            int answer = z(a,b,c);
            sb.append("w(").append(a+", ").append(b+", ").append(c+")").append(" = ");
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    private static int z(int a, int b, int c) {
        if (validCheck(a, b, c) && memory[a][b][c] != 0) {
            return memory[a][b][c];
        } else if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        } else if (a > 20 || b > 20 || c > 20) {
            return memory[20][20][20] = z(20, 20, 20);
        } else if (a < b && b < c) {
            return memory[a][b][c] = z(a, b, c - 1) + z(a, b - 1, c - 1) - z(a, b - 1, c);
        }
        return memory[a][b][c] = z(a - 1, b, c) + z(a - 1, b - 1, c) + z(a - 1, b, c - 1) - z(a - 1, b - 1, c - 1);

    }

    //배열 범위 내의 값인지 유효성 검사하는 메소드
    static boolean validCheck(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }
}
