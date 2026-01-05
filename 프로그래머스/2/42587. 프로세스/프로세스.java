/*
index가 유지되어야 하고, priorities안에 우선순위가 있어야 한다. 

[3,2,2,1] -> 이렇게 정렬을 해두면 좋으려나 ?
[2,1,3,2] -> 이렇게 되어있을 때 max랑 같이 되어있는지 확인이 필요함
*/

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // Max List를 만들어서 정렬하기
        Deque<Integer> maxList = new ArrayDeque<>();
        for (int number : priorities) {
            maxList.add(number);
        }
        
        List<Integer> sortedList = new ArrayList<>(maxList);
        sortedList.sort(Comparator.reverseOrder());
                
        Deque<Integer> sortedMaxList = new ArrayDeque<>(sortedList);
        
        // priorieies를 Deque로 변환
        Deque<Integer[]> prioritesQueue = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            Integer[] data = new Integer[]{i, priorities[i]};
            prioritesQueue.add(data);
        }
        
        // while을 돌면서
        while (prioritesQueue.size() != 0) {
            Integer[] data = prioritesQueue.pollFirst();
            int max = sortedMaxList.peekFirst();
        
            if (data[1] == max) {
                answer++;
                sortedMaxList.pollFirst();
                
                if (data[0] == location) {
                    break;
                }
            } else {
                prioritesQueue.add(data);
            }
        }
        
        return answer;
    }
}