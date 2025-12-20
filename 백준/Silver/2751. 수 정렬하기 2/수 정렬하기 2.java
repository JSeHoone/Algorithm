import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            nums.add(num);
        }
        
        Collections.sort(nums);
        
        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(nums.get(i)).append("\n");
        }
        
        System.out.println(sb);
        
    }
}