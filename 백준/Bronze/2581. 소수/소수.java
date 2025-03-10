import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        
        List<Integer> primeNumberList = new ArrayList<>();
        for (int i = M; i <= N; i++) {
            if (checkPrimeNumber(i)) {
                primeNumberList.add(i);
            }
        }
        
        int sumValue = 0;
        if (primeNumberList.size() != 0) {
            for (int primeNumber : primeNumberList) {
                sumValue += primeNumber;
            }
            
            System.out.println(sumValue);
            System.out.println(primeNumberList.get(0));
        } else {
            System.out.print("-1");
        }
        
        
    }
    
    private static boolean checkPrimeNumber(int num) {
        if (num == 1) {
            return false;
        }
        
        for (int i=2; i*i <= num; i++) {
            if (num % i ==0) {
                return false;
            }
        }
        
        return true;
    }
}