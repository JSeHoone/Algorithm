import java.io.*;
import java.util.*;

public class Main {
    // 상 하 좌 우
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] apartment = new int[N][N];
        for (int i = 0; i < N; i++) {
            int[] row = br.readLine().chars().map(c -> c - '0').toArray();
            apartment[i] = row;
        }
        
        // BFS
        List<Integer> countApartment = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (apartment[i][j] == 1) {
                    bfs(apartment, countApartment,i,j);
                }
            }
        }
        
        StringBuilder response = new StringBuilder();
        response.append(countApartment.size()).append("\n");
        // 오름차순 정렬
        countApartment.sort(Comparator.naturalOrder());

       
        for (int count : countApartment) {
            response.append(count).append("\n");
        }
        
        System.out.print(response);
    }
    
    public static void bfs(int[][] apartment, List<Integer> countApartment, int row, int col) {
        int groupCount = 1;
        apartment[row][col] = -1;
        
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row,col});
        
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = position[0] + dx[i];
                int ny = position[1] + dy[i];
                
                if (nx < 0 || nx >= apartment.length || ny < 0 || ny >= apartment[0].length) {
                    continue;
                }
                
                if (apartment[nx][ny] == 1) {
                    queue.offer(new int[]{nx,ny});
                    apartment[nx][ny] = -1;
                    groupCount++;
                }
            }
        }
        
        countApartment.add(groupCount);
    }
}