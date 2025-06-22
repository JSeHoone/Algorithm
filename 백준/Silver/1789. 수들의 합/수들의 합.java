import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        long answer = 0;
        long num = 1;
        
        while (true) {
            if (answer + num > S) {
                num--;
                break;
            } else {
                answer += num;
                num++;
            }
        }
        
        System.out.print(num);
    }
}