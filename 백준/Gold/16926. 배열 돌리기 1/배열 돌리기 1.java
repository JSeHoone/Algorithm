import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0], M = input[1], loop = input[2];

        // create array
        int[][] array = new int[N][M];
        for (int i = 0; i <N; i++) {
            int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            array[i] = row;
        }

        for (int i = 0; i < loop; i++) {
            // 회전 로직
            int[][] rotatedArray = arrayRotate(array);
        }

        for (int[] row : array) {
            String a = Arrays.stream(row).mapToObj(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(a);
        }
    }

    private static int[][] arrayRotate(int[][] array) {
        int n = array.length;
        int m = array[0].length;
        int layers = Math.min(n, m) / 2;

        for (int layer = 0; layer < layers; layer++) {
            List<Integer> temp = new ArrayList<>();

            // 위쪽
            for (int j = layer; j < m - layer; j++) {
                temp.add(array[layer][j]);
            }
            // 오른쪽
            for (int i = layer + 1; i < n - layer - 1; i++) {
                temp.add(array[i][m - layer - 1]);
            }
            // 아래쪽
            for (int j = m - layer - 1; j >= layer; j--) {
                temp.add(array[n - layer - 1][j]);
            }
            // 왼쪽
            for (int i = n - layer - 2; i > layer; i--) {
                temp.add(array[i][layer]);
            }

            Collections.rotate(temp, -1);

            int idx = 0;
            // 위쪽
            for (int j = layer; j < m - layer; j++) {
                array[layer][j] = temp.get(idx++);
            }
            // 오른쪽
            for (int i = layer + 1; i < n - layer - 1; i++) {
                array[i][m - layer - 1] = temp.get(idx++);
            }
            // 아래쪽
            for (int j = m - layer - 1; j >= layer; j--) {
                array[n - layer - 1][j] = temp.get(idx++);
            }
            // 왼쪽
            for (int i = n - layer - 2; i > layer; i--) {
                array[i][layer] = temp.get(idx++);
            }
        }
        return array;
    }
}
