import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String inputSentences = br.readLine();
        
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        // 1. 빈도 Map을 만들어준다.
        for (char c : inputSentences.toCharArray()) {
            if (c != ' ') {
                // 값이 없으면 0 + 1 있으면 n + 1
                int count = frequencyMap.getOrDefault(Character.toUpperCase(c),0) + 1;
                
                frequencyMap.put(Character.toUpperCase(c), count);                
            }
        }
        
        // 2. 빈도 Map에서 최빈 값을 가져온다.
        char maxChar = '\0';
        int maxCount = 0;
        int frequencyCount = 0;

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxChar = entry.getKey();
                maxCount = entry.getValue();
                frequencyCount = 0;
            } else if (entry.getValue() == maxCount) {
                frequencyCount += 1;
            }
        }
        
        if (frequencyCount != 0) {
            System.out.print("?");
        } else {
            System.out.print(maxChar);
        }
        
    }
}