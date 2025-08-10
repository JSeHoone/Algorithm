import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] numbers = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        
        Long gcd = numbers[0] > numbers[1] ? GCD(numbers[0], numbers[1]) : GCD(numbers[1], numbers[0]);
        System.out.print(numbers[0] * numbers[1] / gcd);
        
    }
    
    private static long GCD(long largeNum, long smallNum) {
        while (true) {
            long remain = largeNum % smallNum;
            
            if (remain == 0) break;
            
            if (remain > smallNum) {
                largeNum = remain;
            } else {
                largeNum = smallNum;
                smallNum = remain;
            }
        }
        
        return smallNum;
    }
}