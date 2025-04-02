import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        
        String[] nk = br.readLine().split(" ");
        int N = Integer.parseInt(nk[0]);
        int K = Integer.parseInt(nk[1]);
        
        int[] coinsValue = new int[N];
        
        // 오름차순으로 주어지니까 그대로 넣어주자
        for (int i=0; i < N; i++) {
            int coinValue = Integer.parseInt(br.readLine());
            coinsValue[i] = coinValue;
        }
        
        // count answer 
        for (int i = N-1; i >= 0; i--) {
            int coinValue = coinsValue[i];
            
            if ((K / coinValue) != 0) {
                answer += K / coinValue;
                K = K % coinValue;
                if (K == 0) {
                    break;
                }
            }
        }
        
        System.out.print(answer);
        
            
    }
}