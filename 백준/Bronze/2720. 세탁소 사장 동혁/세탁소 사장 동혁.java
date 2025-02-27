import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int testCount = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= testCount; i++) {
            // init change
            int quarter = 0;
            int dime = 0;
            int nickel = 0;
            int penny =0;            
            int change = Integer.parseInt(br.readLine());
            
            // quarter(0.25) 25cent
            quarter += (change / 25);
            change = (change % 25);
            
            // dime(0.10) 10cent;
            dime += (change / 10);
            change = (change % 10);
            
            // nickel(0.05) 5cent
            nickel += (change / 5);
            change = (change % 5);
            
            // penny(0.01) 1cent
            penny += change;
            
            System.out.printf("%d %d %d %d\n", quarter, dime, nickel, penny);
        }
    }
}