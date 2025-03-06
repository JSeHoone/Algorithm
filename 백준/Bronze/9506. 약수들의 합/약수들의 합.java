import java.io.*;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int number = Integer.parseInt(br.readLine());
            
            if (number == -1) {
                break;
            }
            
            if (number == 1) {
                System.out.print("1 is NOT perfect. \n");
                continue;
            }
            
            int until = (int) Math.sqrt(number);
            ArrayList<Integer> divisors = new ArrayList<>();
            
            for (int i = 1; i <= until; i++ ) {
                if (number % i == 0) {
                    divisors.add(i);
                }
            }
            
            ArrayList<Integer> newDivisors = new ArrayList<>();
            int sumDivisor = 0;
            for (int divisor : divisors) {
                newDivisors.add(divisor);
                sumDivisor += divisor;
                
                int quotient = number / divisor;
                
                if (quotient != divisor) {
                    if (quotient != number) {
                        newDivisors.add(quotient);
                        sumDivisor += quotient;
                    }
                }
                
            }
            
            // 오름차순으로 정렬
            Collections.sort(newDivisors);
            
            if (sumDivisor == number) {
                System.out.print(number + " = ");
                for (int i=0; i < newDivisors.size() - 1; i++) {
                    int divisor = newDivisors.get(i);
                    System.out.print(divisor + " + ");
                }
                System.out.print(newDivisors.get(newDivisors.size() -1));
                System.out.print("\n");
            } else {
                System.out.println(number + " is NOT perfect.");
            }
        }
    }
}