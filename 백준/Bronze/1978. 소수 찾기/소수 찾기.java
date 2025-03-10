import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberCount = Integer.parseInt(br.readLine());
        Integer[] numberList = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        
        int countPrimeNumber = 0;
        for (int number : numberList) {
            if (checkPrimeNumber(number)) {
                countPrimeNumber++;
            }
        }
        
        System.out.print(countPrimeNumber);
        
    }
    
    private static boolean checkPrimeNumber (int num) {
        if (num == 1) {
            return false;
        }
        
        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}