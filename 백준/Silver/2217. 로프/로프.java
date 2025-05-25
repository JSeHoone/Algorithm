import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int maxValue = 0;
        int N = Integer.parseInt(br.readLine());
        int[] ropes = new int[N];
        
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            ropes[i] = num;
        }
        
        Arrays.sort(ropes);
        
        for (int i = 0; i < N; i++) {
            int ropeCount = N - i;
            int calNum = ropes[i] * ropeCount;
            
            if (calNum > maxValue) {
                maxValue = calNum;
            }
        }
        
        System.out.print(maxValue);

        
    }
}