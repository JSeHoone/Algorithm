import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            Integer[] numbers = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            
            if (numbers[0] == 0 && numbers[1] == 0){
                break;
            }
            
            // 약수인 경우
            int factor = numbers[1] % numbers[0];
            // 배수인 경우
            int multiple = numbers[0] % numbers[1];
            
            if (factor == 0) {
                System.out.println("factor");
            } else if (multiple == 0) {
                System.out.println("multiple");
            } else {
                System.out.println("neither");
            }
        }
    }
}