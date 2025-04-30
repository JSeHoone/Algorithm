import java.io.*;

public class Main{
    private static int N;
    private static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        answer = 1;
        
        if (N == 0) {
            System.out.print(1);
        } else {
            factorial(1);
            System.out.print(answer);
        }
    }
    
    public static void factorial(int num) {
        if (num > N) {
            return;
        }
        answer *= num;
        factorial(num + 1);
    }

}