import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int loop = Integer.parseInt(br.readLine());
            
        List<Integer[]> chakerboard = makeChakerboard();
        
        for (int i = 1; i <= loop; i++) {
            Integer[] start = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    int row = start[0] + j;
                    int col = start[1] + k;
                    
                    chakerboard.get(row)[col] = 1;
                }
            }
        }
        
        // count 1
        long count = 0L;
        for (Integer[] row : chakerboard) {
            long countOne = Arrays.stream(row).filter(num -> num.equals(1)).count();
            count += countOne;
        }
        
        System.out.printf("%d", count);
        
        
    }
    
    private static List<Integer[]> makeChakerboard() {
        List<Integer[]> chakerboard = new ArrayList<>();
        
        for (int i = 0; i<100; i++) {
            Integer[] row = new Integer[100];
            Arrays.fill(row,0);
            chakerboard.add(row);
        }
        return chakerboard;        
    }
}