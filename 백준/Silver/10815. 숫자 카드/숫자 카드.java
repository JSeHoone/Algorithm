import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Set<Integer> cardsSet = new HashSet<>();
        int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        for (int card : cards) {
            cardsSet.add(card);
        }
        
        int loop = Integer.parseInt(br.readLine());
        int[] cardsTest = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        StringBuilder sb = new StringBuilder();
        for (int card : cardsTest) {
            if (cardsSet.contains(card)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        
        System.out.println(sb);
    }
}