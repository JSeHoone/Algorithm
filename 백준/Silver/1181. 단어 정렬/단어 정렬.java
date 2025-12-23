import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        String[] words = set.toArray(new String[0]);

        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) return a.length() - b.length();
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for (String w : words) sb.append(w).append('\n');
        System.out.print(sb);
    }
}
