import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] array = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        arrayRotate(array, R);

        StringBuilder sb = new StringBuilder();
        for (int[] row : array) {
            for (int j = 0; j < M; j++) {
                sb.append(row[j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void arrayRotate(int[][] array, int R) {
        int n = array.length;
        int m = array[0].length;
        int layers = Math.min(n, m) / 2;

        for (int layer = 0; layer < layers; layer++) {
            // 현재 layer 길이
            int height = n - 2 * layer;
            int width = m - 2 * layer;
            int len = 2 * (height + width) - 4;

            int[] temp = new int[len];
            int idx = 0;

            // 추출
            for (int j = layer; j < m - layer; j++) temp[idx++] = array[layer][j];
            for (int i = layer + 1; i < n - layer - 1; i++) temp[idx++] = array[i][m - layer - 1];
            for (int j = m - layer - 1; j >= layer; j--) temp[idx++] = array[n - layer - 1][j];
            for (int i = n - layer - 2; i > layer; i--) temp[idx++] = array[i][layer];

            // 회전
            int rot = R % len;
            int[] rotated = new int[len];
            for (int i = 0; i < len; i++) {
                rotated[i] = temp[(i + rot) % len];
            }

            // 다시 넣기
            idx = 0;
            for (int j = layer; j < m - layer; j++) array[layer][j] = rotated[idx++];
            for (int i = layer + 1; i < n - layer - 1; i++) array[i][m - layer - 1] = rotated[idx++];
            for (int j = m - layer - 1; j >= layer; j--) array[n - layer - 1][j] = rotated[idx++];
            for (int i = n - layer - 2; i > layer; i--) array[i][layer] = rotated[idx++];
        }
    }
}
