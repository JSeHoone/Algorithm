/*
저장된 사이트의 수 N 비밀번호를 찾으려고 하는 사이트 주소의 수 M

N개의 줄에 걸쳐 사이트 주소와 비밀번호가 공백으로 구분되어 주어진다.
이후 M개의 줄에 걸쳐서 비밀번호를 찾고자 하는 사이트를 출력한다.
*/

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int M = input[1];
        
        // HashMap 생성
        Map<String, String> siteMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] siteInfo = br.readLine().split(" ");
            siteMap.put(siteInfo[0], siteInfo[1]);
        }
        
        // 비밀번호 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String checkSite = br.readLine();
            String findPassword = siteMap.get(checkSite);
            sb.append(findPassword).append("\n");
        }
        
        System.out.println(sb);
    }
}