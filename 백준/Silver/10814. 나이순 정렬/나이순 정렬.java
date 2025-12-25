/*
나이가 증가하는 순으로 정렬을 하는데, 나이가 동일한 경우에는 먼저 가입한 순으로 정렬을 진행한다.
*/

import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{ 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        List<String[]> people = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            String[] personInfo = br.readLine().split(" ");
            String[] newPersonInfo = new String[]{
                String.valueOf(i),
                personInfo[0],
                personInfo[1]};
            
            people.add(newPersonInfo);
        }
        
        // 정렬 
        people.sort(
            Comparator.comparingInt((String[] p) -> Integer.parseInt(p[1])) // 나이 오름차순
                      .thenComparingInt(p -> Integer.parseInt(p[0]))        // 가입 순서
        );

        
        // 출력
        StringBuilder sb = new StringBuilder();
        for (String[] p : people) {
            sb.append(p[1]).append(" ").append(p[2]).append("\n");
        }

        System.out.println(sb);
    }
    
}