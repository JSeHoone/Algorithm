import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] input = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int N = input[0];
        int loop = input[1];
        
        Integer[] intArray = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        
        int[] sumArray = new int[N];
        int temp = 0;
        for (int i =0; i < N; i++) {
            temp += intArray[i];
            sumArray[i] = temp;
        }

        StringBuilder response = new StringBuilder();
        for (int i =0; i < loop; i++) {
            Integer[] position = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            int start = position[0] -1;
            int end = position[1] -1;
            
            int result = (start == 0) ? sumArray[end] : sumArray[end] - sumArray[start - 1];
            response.append(result).append("\n");
        }
        System.out.print(response);
        
        
          
    }
}