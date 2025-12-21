import java.util.*;
import java.io.*;

// 계수 정렬 알고리즘
// - 데이터의 값 범위가 제한적(10,000이하)이고 정수일 때, 값의 크기를 세는 방식의 알고리즘
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] countArray = new int[10000+1];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            countArray[num]++;
        }
        
        // count sort
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 10001; i++) {
            while(countArray[i] > 0) {
                sb.append(i).append("\n");
                countArray[i]--;
            }
        }
        System.out.println(sb);
    }
}