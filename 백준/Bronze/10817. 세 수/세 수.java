import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] input = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        
        Arrays.sort(input, Collections.reverseOrder());
        
        System.out.print(input[1]);
    }
}