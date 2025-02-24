import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N X M
        Integer[] matrix = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        
        List<Integer[]> one = new ArrayList<>();
        List<Integer[]> two = new ArrayList<>();
        
        for (int i = 1; i <= matrix[0]*2; i++) {
            Integer[] input = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            if (i <= matrix[0]) {
                // 첫 번째
                one.add(input);
            } else {
                // 두 번째
                two.add(input);
            }
        }
        
        // Calculate add 
        List<Integer[]> response = new ArrayList<>();
        for (int i = 0; i < matrix[0]; i++) {
            Integer[] row = new Integer[matrix[1]];
            for (int j = 0; j < matrix[1]; j++) {
                row[j] = one.get(i)[j] + two.get(i)[j];
            }
            response.add(row);
        }
        
        // print
        for (int i = 0; i < matrix[0]; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < matrix[1]; j++) {
                sb.append(response.get(i)[j]).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}