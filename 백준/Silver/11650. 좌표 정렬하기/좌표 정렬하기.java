import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] array = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            int[] unit = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            array[i] = unit;
        }
        
        Arrays.sort(array, (e1,e2) -> {
            if (e1[0] == e2[0]) {
                return e1[1] - e2[1];
            } else {
                return e1[0] - e2[0];
            }
        });
        
        
        StringBuilder sb = new StringBuilder();
        for (int[] unit : array) {
            sb.append(unit[0]).append(" ").append(unit[1]).append("\n");
        }
        
        System.out.println(sb);
           
    }
}