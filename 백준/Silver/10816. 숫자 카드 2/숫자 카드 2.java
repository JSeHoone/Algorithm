import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(cards); 
        
        int testLoop = Integer.parseInt(br.readLine());
        int[] testCase = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Map<Integer, Integer> count = new HashMap<>();
        for (int x : cards) count.put(x, count.getOrDefault(x, 0) + 1);

        StringBuilder sb = new StringBuilder();
        for (int q : testCase) {
            sb.append(count.getOrDefault(q, 0)).append(" ");
        }

        System.out.println(sb);
    }
}