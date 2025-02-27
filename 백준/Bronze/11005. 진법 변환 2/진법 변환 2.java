import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Integer[] input = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int inputNumber = input[0];
        int base = input[1];
        
        String remainder = "";
        
        while (inputNumber != 0) {
            int quotient = inputNumber / base;
            int remain = inputNumber % base;
            
            if (base != 10) {
                if (remain > 9) {
                    int remainToAscii = remain + 55;
                    char ascii = (char) remainToAscii;
                    
                    remainder += ascii;
                } else {
                    remainder += String.valueOf(remain);
                }
            } else {
                remainder += String.valueOf(remain);            
            }
            
            inputNumber = quotient;
        }
        
        StringBuilder reverseRemainder = new StringBuilder();
        
        for (int i = 0; i < remainder.length(); i++) {
            char a = remainder.charAt(remainder.length() -1 -i);
            reverseRemainder.append(a);
        }
        
        System.out.print(reverseRemainder);
        
    }
}