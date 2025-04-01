import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        int[] origin = new int[loop];
        int[] sortCopy = new int[loop];
        HashMap<Integer, Integer> compress = new HashMap<Integer, Integer>();
        
        // String Tokenizer
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i < loop; i++) {
           origin[i] = sortCopy[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(sortCopy);
        
        int compressNumber = 0;
        for (int value : sortCopy) {
            if (!compress.containsKey(value)) {
                compress.put(value, compressNumber);
                compressNumber++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int num : origin) {
            int convertNum = compress.get(num);
            sb.append(convertNum).append(" ");
        }
        
        System.out.print(sb);
    }  
}