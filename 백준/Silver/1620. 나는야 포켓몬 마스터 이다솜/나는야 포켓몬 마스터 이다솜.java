/*
도감에 수록되어있는 포켓몬 N, 맞춰야 하는 문제 M이 주어짐

이후에는 포켓몬 번호가 1번인 포켓몬부터 N번에 해당하는 포켓몬까지 한줄에 하나씩 입력으로 들어옴
-> 일부 포켓몬은 마지막 문자만 대문자일 수 있음.

그 다음 M번째 줄에는 내가 맞춰야 하는 문제가 입력으로 들어온다.
-> 알파벳으로 문제가 들어오면 번호를 말해야하고, 숫자로 들어오면 문자를 입력해야 한다. 

Map으로 포켓몬을 저장하고, 출력하면 될 듯하다.
*/

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int M = input[1];
        
        // 도감 생성
        Map<String, String> poketBook = new HashMap<>();
        for (int i = 1; i < N+1; i++) {
            String poketmon = br.readLine();
            poketBook.put(String.valueOf(i), poketmon);
            poketBook.put(poketmon, String.valueOf(i));
        }
        
        // 문제 확인
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String mission = br.readLine();
            
            sb.append(poketBook.get(mission)).append("\n");
        }
        
        System.out.println(sb);
        
    }
}