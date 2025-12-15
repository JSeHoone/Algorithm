import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int answer = 1;
        
        if (N != 0 || N != 1) {
            for (; N > 1; N--) {
                answer *= N;
            }
        }
        
        System.out.println(answer);
       
    }
}