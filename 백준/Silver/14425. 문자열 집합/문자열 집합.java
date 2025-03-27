import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        
        Integer[] numbers = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        
        // create dict
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        
        for (int i = 1; i <= numbers[0]; i++) {
            String key = br.readLine();
            dict.put(key,1);
        }
        
        // check
        for (int i = 1; i <= numbers[1]; i++) {
            String word = br.readLine();
            if (dict.containsKey(word)) {
                answer ++;
            }
        }
        
        System.out.print(answer);
    }
}