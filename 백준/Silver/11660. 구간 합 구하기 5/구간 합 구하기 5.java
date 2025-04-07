import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int loop = Integer.parseInt(input[1]);
        
        // prifix sum array
        int[][] prefixSum = new int[N+1][N+1];
        Integer[] firstRow = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        for (int i = 1; i <= N; i++) {
            prefixSum[1][i] = prefixSum[1][i-1] + firstRow[i-1];
        }
        
        // 2row prifix sum
        for (int i=2; i<=N; i++) {
            Integer[] row = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            for (int j = 1; j<=N; j++) {
                prefixSum[i][j] = prefixSum[i][j-1] + prefixSum[i-1][j] - prefixSum[i-1][j-1] + row[j-1];
            }
        }
        
        // loop
        StringBuilder response = new StringBuilder();
        for (int i = 1; i <= loop; i++) {
            Integer[] position = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            int x1 = position[0]-1;
            int y1 = position[1]-1;
            int x2 = position[2]-1;
            int y2 = position[3]-1;
            
            int answer = prefixSum[x2+1][y2+1] - prefixSum[x1][y2+1] - prefixSum[x2+1][y1] + prefixSum[x1][y1];
            response.append(answer).append("\n");
        }
        
        System.out.print(response);
    }
}