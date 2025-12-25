/*
나이가 증가하는 순으로 정렬을 하는데, 나이가 동일한 경우에는 먼저 가입한 순으로 정렬을 진행한다.
*/

import java.util.*;
import java.io.*;

public class Main{ 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        String[][] people = new String[N][2];
        
        for (int i = 0; i < N; i++) {
            String[] person = br.readLine().split(" ");
            people[i] = person;
        }
        
        // 정렬 
        // 1. 나이가 증가하는 순으로 정렬
        Arrays.sort(people, (p1, p2) -> {
            return Integer.parseInt(p1[0]) - Integer.parseInt(p2[0]);
        });

        
        // 출력
        StringBuilder sb = new StringBuilder();
        for (String[] p : people) {
            sb.append(p[0]).append(" ").append(p[1]).append("\n");
        }

        System.out.println(sb);
    }
    
}