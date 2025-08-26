import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{priorities[i], i}); // [priority, index]
            pq.add(priorities[i]);                  // 우선순위만 관리
        }

        int order = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == pq.peek()) { // 현재 문서가 가장 높은 우선순위
                pq.poll();
                order++;
                if (cur[1] == location) {
                    return order;
                }
            } else {
                queue.add(cur); // 뒤로 보냄
            }
        }
        return -1;
    }
}
