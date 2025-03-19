import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Stack
        Stack<Integer> stack = new Stack<>();
        
        // loop count
        int loop = Integer.parseInt(br.readLine());
        int totalAdd = 0;
        for (int i = 1; i<= loop; i++) {
            int num = Integer.parseInt(br.readLine());
            
            if (num == 0) {
                if (stack.empty()) {
                    continue;
                } else {
                    int preNum = stack.pop();
                    totalAdd -= preNum;
                }
            } else {
                stack.push(num);
                totalAdd += num;
            }
        }
        
        System.out.print(totalAdd);
    }
}