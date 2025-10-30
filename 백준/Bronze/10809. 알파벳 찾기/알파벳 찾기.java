import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 알파벳
        Map<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            dict.put((char) (i + 'a'), -1);
        }

        // input word
        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            char alphabet = input.charAt(i);
            boolean isExist = dict.containsKey(alphabet);
            if (isExist && dict.get(alphabet) == -1) {
                dict.put(alphabet, i);
            }
        }

        // out
        StringBuilder sb = new StringBuilder();
        for (int value : dict.values()) {
            sb.append(value).append(" ");
        }
        System.out.println(sb);

    }
}
