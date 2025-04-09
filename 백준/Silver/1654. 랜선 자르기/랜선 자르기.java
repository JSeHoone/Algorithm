import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int target = Integer.parseInt(input[1]);
        
        long start = 1;
        long maxValue = 0;
        long[] intArray = new long[N];
        
        for (int i = 0; i < N; i++) {
            long value = Long.parseLong(br.readLine());
            intArray[i] = value;
            
            if (maxValue < value) {
                maxValue = value;
            }
        }
        
        // binary search
        long result = 0;
        while (start <= maxValue) {
            long midValue = start + (maxValue - start) / 2;
            long count = 0;
            
            for (long lan : intArray) {
                count += lan / midValue;
            }
            
            if (count < target) {
                maxValue = midValue - 1;
            } else {
                result = midValue; 
                start = midValue + 1;
            }
        }
        
        System.out.print(result);
    }
}
