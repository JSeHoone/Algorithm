import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int step = Integer.parseInt(input[1]);
        char[] table = br.readLine().toCharArray();
        
        int count = 0;
        
        for (int i = 0; i < table.length; i++) {
            // 사람이 아니라면 pass
            if (table[i] != 'P') {
                continue;
            }            
            for (int j = i-step; j < i+step+1 ; j++) {
                if ( (j >= 0) && (j < N) ) {
                    if (table[j] == 'H') {
                        table[j] = '-';
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.print(count);
        
    }
}