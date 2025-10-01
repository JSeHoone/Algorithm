/*

[1,2,3,4,5]가 주어졌을 때, 
택배 기사가 알려준 순서에 맞게 택배상자를 실어야 함

보조 컨테이너 벨트는 Stack으로 구현되어있음

1. main에 [1,2,3,4,5]가 올라와 있음
2. order 순서대로 트럭에 실어야 함
order의 index 순서대로 돌려야함.

1. main의 peek값이 order와 일치하면 answer++
2. 일치하지 않으면 sub를 확인해야하니 sub가 비어있다면 main의 peek값 삽입
3. 비어있지 않다면 sub의 peek값이랑 order확인 후, 일치하면 answer++
4. 일치하지 않다면 break




*/


import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int n = order.length;

        Queue<Integer> main = new LinkedList<>();
        Stack<Integer> sub = new Stack<>();

        for (int i = 1; i <= n; i ++) {
            main.add(i);
        }

        while (answer != n) {
            int target = order[answer];

            // 1. main이 비어있지 않고, target이 main.peek()과 같으면 꺼냄
            if (!main.isEmpty() && main.peek() == target) {
                main.poll();
                answer++;
            }
            // 2. sub이 비어있지 않고, target이 sub.peek()과 같으면 꺼냄
            else if (!sub.isEmpty() && sub.peek() == target) {
                sub.pop();
                answer++;
            }
            // 3. main에서 sub로 옮길 수 있으면 옮김
            else if (!main.isEmpty()) {
                sub.push(main.poll());
            }
            // 4. 더 이상 진행 불가
            else {
                break;
            }

        }

        return answer;
    }
}