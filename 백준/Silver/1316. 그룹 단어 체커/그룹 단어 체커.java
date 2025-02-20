import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int loop = Integer.parseInt(br.readLine());
        int count = 0;
        
        for (int i = 1; i <= loop; i++) {
            String word = br.readLine();
            boolean check = checkGroupWord(word);
            
            if (Boolean.TRUE.equals(check)) {
                count += 1;
            }
            
        }
        
        System.out.print(count);
    }
    
    public static boolean checkGroupWord(String word) {
        Set<Character> seen = new HashSet<>();
        char prev = '\0';
        
        for (char c : word.toCharArray()) {
            if (prev != c) {
                if (seen.contains(c)) {
                    return false;
                }
                seen.add(c);
            }
            prev = c;
        }
        
        return true;
    }
}