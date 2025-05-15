import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<String, String> hm = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            if (hm.containsKey(input[0])) {
                hm.replace(input[0], input[1]);
            }
            hm.putIfAbsent(input[0], input[1]);
        }

        StringBuilder sb = new StringBuilder();
        List<String> response = new LinkedList<>();
        for (String name : hm.keySet()) {
            if (hm.get(name).equals("enter")) {
                response.add(name);
            }
        }

        response.sort(Comparator.reverseOrder());
        for (String name : response) {
            sb.append(name).append("\n");
        }
        System.out.println(sb);
    }
}
