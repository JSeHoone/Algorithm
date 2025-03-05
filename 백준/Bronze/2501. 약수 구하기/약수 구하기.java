import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Integer[] input = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        
        int response = 0;
        int count = 0;
        
        for (int i = 1; i <= input[0]; i++) {
            if (input[0] % i == 0) {
                count++;
                if (count == input[1]) {
                    response = i;
                    break;
                }
            }
        }
        
        System.out.print(response);
    }
}