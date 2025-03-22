import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        
        // ASCII 문자 범위로 가정하여 크기를 128로 설정 (필요에 따라 256 사용 가능)
        int[] count = new int[128];
        for (char c : s) {
            count[c]++;
        }
        
        StringBuilder answer = new StringBuilder();
        // 내림차순 정렬: 큰 문자부터 출력
        for (int i = 127; i >= 0; i--) {
            while (count[i]-- > 0) {
                answer.append((char) i);
            }
        }
        
        System.out.print(answer);
    }
}
