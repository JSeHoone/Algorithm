/*
마라톤을 완주하지 못한 사람을 출력하는 것인데, 1명임.
동명이인이 있을 수 있음

참가자는 10^5(100,000)명까지 참여함
> O(N^2)을 가져가면 시간 초과가 발생함.

O(3N)의 시간복잡도를 가질 것 같음

Map으로 관리하려고 했는데, 동명이인이 있어서 중복관리가 안됨

*/

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        // 참여자를 Map으로 관리 (동명이인이 있을 수 있으니 Integer로 관리)
        Map<String, Integer> people = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String person = br.readLine();
            
            if (people.containsKey(person)) {
                people.put(person, people.get(person) + 1);
            } else {
                people.put(person, 1);
            }
        }
        
        // N-1명의 완주자를 등록
        for (int i = 0; i < N-1; i++) {
            String completedPerson = br.readLine();
            people.put(completedPerson, people.get(completedPerson)-1);
        }
        
        // 완주하지 못한 사람 출력
        for (String person : people.keySet()) {
            if (people.get(person) != 0) {
                System.out.print(person);
                break;
            }
        }
    }
}
