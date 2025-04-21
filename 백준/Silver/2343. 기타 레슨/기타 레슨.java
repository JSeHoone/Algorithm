import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        
        int[] disc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int left = Arrays.stream(disc).max().getAsInt();
        int right = Arrays.stream(disc).sum();
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 1;
            int total = 0;
            
            for (int d : disc) {
                if (total + d <= mid) {
                    total += d;
                } else {
                    total = d;
                    cnt++;
                }
            }
            
            if (M < cnt) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        
        System.out.print(left);
    }
}