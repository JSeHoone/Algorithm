import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> userSet = new HashSet<>();
        int count = 0;
    
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.equals("ENTER")) {
                userSet.clear();
            } else {
                if (userSet.add(input)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}