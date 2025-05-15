import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int lengA = Integer.parseInt(input[0]);
        int lengB = Integer.parseInt(input[1]);
        
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(B);
        
        int unionCount = 0;
        
        for (int unitA : A) {
            if (Arrays.binarySearch(B, unitA) >= 0) {
                unionCount++;
            }
        }
        
        int response = 0;
        response += A.length - unionCount;
        response += B.length - unionCount;
        
        System.out.print(response);
    }
}