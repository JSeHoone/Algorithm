import java.io.*;
import java.util.Arrays;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] parts = br.readLine().split(" ");
        
        String number = parts[0];
        int N = Integer.parseInt(parts[1]);
        

        if (N == 10) {
            System.out.print(number);
        } else {
            int response = 0;
            int exponent = number.length() - 1;
            
            for (int i = 0; i < number.length(); i++) {
                int convertInt = (int) number.charAt(i);
                if (convertInt < 65) {
                    convertInt -= 48;
                } else {
                    convertInt -= 55;
                }
                
                int calculate = convertInt * (int) Math.pow(N,exponent);
                response += calculate;
                exponent--;
            }
            
            System.out.printf("%d", response);
        }
        
        
    }
   
}