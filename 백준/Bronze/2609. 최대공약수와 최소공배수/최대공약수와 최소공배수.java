import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int A = inputs[0];
        int B = inputs[1];
        
        // GCD
        int gcd = GCD(A,B);
        
        // LCM
        int lcm = (A * B) / gcd;
        
        // output
        System.out.println(gcd);
        System.out.println(lcm);
    }
    
    public static int GCD(int a, int b) {
        while (b > 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        
        return a;
    }
}