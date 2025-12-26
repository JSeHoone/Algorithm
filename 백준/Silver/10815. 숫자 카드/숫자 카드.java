/*
이분 탐색
정렬하고 중앙 index가 

*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(cards);
        
        int testN = Integer.parseInt(br.readLine());
        int[] testCards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        StringBuilder sb = new StringBuilder();
        for (int testCard : testCards) {
            if (isExists(cards, testCard)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        
        System.out.println(sb);
        
    }
    
    public static boolean isExists(int[] cards, int target) {
        int left = 0;
        int right = cards.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int value = cards[mid];
            
            if (value == target) {
                return true;
            } else if (value > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return false;
    }
    

}