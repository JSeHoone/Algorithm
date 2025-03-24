import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String[] cards = br.readLine().split(" ");
        
        HashMap<String, Integer> hm = new HashMap<String,Integer>();
        for (String card : cards) {
            hm.put(card, 1);
        }
        
        int M = Integer.parseInt(br.readLine());
        String[] checks = br.readLine().split(" ");
        
        for (String check : checks) {
            if (hm.containsKey(check)) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
    }
}