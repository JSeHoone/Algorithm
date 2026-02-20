import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(data);

        int testLoop = Integer.parseInt(br.readLine());
        int[] testCase = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        StringBuilder sb = new StringBuilder();
        for (int test : testCase) {
            int index = Arrays.binarySearch(data,test);
            if (index < 0) {
                sb.append(0).append("\n");
            } else {
                sb.append(1).append("\n");
            }
        }

        System.out.println(sb);
    }

    
}