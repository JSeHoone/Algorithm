import java.io.*;
import java.util.*;

public class Main {
    static int col;
    static int row;
    // 상 하 좌 우 
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        row = Integer.parseInt(input[0]);
        col = Integer.parseInt(input[1]);
        
        int[][] maze = new int[row][col];
        int[][] visited = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(visited[i], -1);
        }
        
        for (int i = 0; i < row; i++) {
            int[] line = Arrays.stream(br.readLine().split(""))
                               .mapToInt(Integer::parseInt)
                               .toArray();
            maze[i] = line;
        }
        
        bfs(maze, visited);
        System.out.print(visited[row - 1][col - 1]);
    }
    
    public static void bfs(int[][] maze, int[][] visited) {
        Queue<Point> deque = new LinkedList<>();
        visited[0][0] = 1;
        deque.offer(new Point(0, 0));
        
        while (!deque.isEmpty()) {
            Point current = deque.poll();
            int x = current.x;
            int y = current.y;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i]; 
                int ny = y + dy[i]; 
                
                if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
                    continue;
                }
                
                if (maze[nx][ny] == 1 && visited[nx][ny] == -1) {
                    visited[nx][ny] = visited[x][y] + 1;
                    deque.offer(new Point(nx, ny));
                }
            }
        }
    }
}
