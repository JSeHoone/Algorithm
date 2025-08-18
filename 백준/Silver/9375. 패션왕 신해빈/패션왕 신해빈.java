import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            HashMap<String, Integer> wears = new HashMap<>();

            // put wears info
            for (int j = 0; j < N; j++) {
                String[] wear = br.readLine().split(" ");
                if (wears.containsKey(wear[1])) {
                    wears.put(wear[1] , wears.get(wear[1]) + 1);
                } else {
                    wears.put(wear[1], 1);
                }
            }

            // calculate combination
            int result = 1;
            for (int value : wears.values()) {
                result = result * (value + 1);
            }

            System.out.println(result - 1);
        }
    }

}
