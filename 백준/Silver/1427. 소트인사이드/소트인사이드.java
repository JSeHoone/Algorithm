import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        // 입력 문자열을 Character 배열로 변환합니다.
        Character[] a = new Character[input.length()];
        for (int i = 0; i < input.length(); i++) {
            a[i] = input.charAt(i);
        }
        
        // Collections.reverseOrder()를 사용하여 내림차순 정렬합니다.
        Arrays.sort(a, Collections.reverseOrder());
        
        StringBuilder answer = new StringBuilder();
        for (char c : a) {
            answer.append(c);
        }
        
        System.out.print(answer);
    }
}
