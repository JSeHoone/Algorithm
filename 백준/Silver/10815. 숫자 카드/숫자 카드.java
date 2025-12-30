import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Set으로 카드 정보 저장 - Set을 이용해서 중복 카드 제거
        int N = Integer.parseInt(br.readLine());
        int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        Set<Integer> cardsSet = new HashSet<>();
        
        for (int card : cards) {
            cardsSet.add(card);
        }
        
        // 검증하고자 하는 카드들을 For문 돌면서 확인
        int testCount = Integer.parseInt(br.readLine());
        int[] verificationCards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        StringBuilder sb = new StringBuilder(); // 출력 최적화를 위한 String Builder 사용
        for (int card : verificationCards) {
            if (cardsSet.contains(card)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        
        System.out.println(sb);
        
    }
}