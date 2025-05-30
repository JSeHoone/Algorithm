import java.io.*;
import java.util.*;

public class Main {
    private static long[] memory;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int loop = Integer.parseInt(br.readLine());
        int[] targets = new int[loop];
        int maxN = 0;
        for (int i =0; i < loop; i++) {
            targets[i] = Integer.parseInt(br.readLine());
            maxN = Math.max(maxN, targets[i]);
        }

        memory = new long[Math.max(101, maxN+1)];
        memory[1] = memory[2] = memory[3] = 1;

        for (int i = 4; i <= maxN; i++) {
            memory[i] = memory[i-2] + memory[i-3];
        }

        for (int target : targets) {
            System.out.println(memory[target]);
        }
    }
}
