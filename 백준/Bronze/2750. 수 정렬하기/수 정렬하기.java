import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int loop = Integer.parseInt(br.readLine());
        int[] nums = new int[loop];
        
        for (int i = 0; i < loop; i++) {
            int num = Integer.parseInt(br.readLine());
            nums[i] = num;
        }
        
        Arrays.sort(nums);
        
        for (int num : nums) {
            System.out.println(num);
        }
    }
}