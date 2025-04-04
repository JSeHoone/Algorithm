import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int X = Integer.parseInt(firstLine[1]);
        
        String[] secondLine = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(secondLine[i]);
        }
        
        int sw = 0;
        for (int i = 0; i < X; i++) {
            sw += arr[i];
        }
        
        int maxSum = sw;
        int maxCnt = 1;
        
        for (int i = X; i < N; i++) {
            sw = sw - arr[i - X] + arr[i];
            if (sw == maxSum) {
                maxCnt++;
            } else if (sw > maxSum) {
                maxSum = sw;
                maxCnt = 1;
            }
        }
        
        if (maxSum == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxSum);
            System.out.println(maxCnt);
        }
    }
}
