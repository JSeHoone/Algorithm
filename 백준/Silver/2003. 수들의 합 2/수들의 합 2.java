import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int target = Integer.parseInt(input[1]);
        Integer[] array = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        
        int start = 0;
        int end = 0;
        int answer = 0;
        int prefixSum = 0;
        
        while (true) {
            if (prefixSum >= target) {
                prefixSum -= array[start];
                start++;
            } else {
                if (end == N) {
                    break;
                }
                prefixSum += array[end];
                end++;
            }
            
            if (prefixSum == target) {
                answer++;
            }
        }
        System.out.print(answer);
    }
}