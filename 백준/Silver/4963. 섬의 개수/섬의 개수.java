import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = { 1, 1, 0, -1, -1, -1, 0, 1 };
    static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
    
    public static void dfs(int i, int j, int[][] landMap, boolean[][] visited, int row, int col) {
        visited[i][j] = true;
        
        for (int d = 0; d < 8; d++) {
            int ni = i + dy[d];
            int nj = j + dx[d];
            if (ni >= 0 && ni < row && nj >= 0 && nj < col && !visited[ni][nj] && landMap[ni][nj] == 1) {
                dfs(ni, nj, landMap, visited, row, col);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringBuilder response = new StringBuilder();
        while (true) {
            String[] inputSize = br.readLine().split(" ");
            int col = Integer.parseInt(inputSize[0]);
            int row = Integer.parseInt(inputSize[1]);
            
            // 반복이 중지되는 순간
            if (col == 0 && row == 0) {
                break;
            }
            
            // 지도 만들기
            int[][] landMap = new int[row][col];
            for (int i = 0; i < row; i++) {
                int[] rowValue = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                landMap[i] = rowValue;
            }
            
            // DFS
            boolean[][] visited = new boolean[row][col];
            int isLandCount = 0;
            
            for (int i =0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (!visited[i][j] && landMap[i][j] == 1){
                        dfs(i,j,landMap, visited, row, col);
                        isLandCount++;
                    }
                }
            }
            
            response.append(isLandCount).append("\n");
        }
        
        System.out.print(response);
    }
    
}