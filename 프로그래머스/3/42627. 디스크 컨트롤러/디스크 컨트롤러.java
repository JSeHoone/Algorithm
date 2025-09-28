import java.util.*;

class Solution {
    class Program {
        int requestTime;
        int workTime;
        
        public Program(int rt, int wt) {
            this.requestTime = rt;
            this.workTime = wt;
        }
    }
    public int solution(int[][] jobs) {
        int answer = 0;
        int n = jobs.length;
        
        // 요청 시간 기준으로 정렬
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        
        PriorityQueue<Program> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.workTime));

        int time = 0, idx = 0, count = 0;
        
        while (count < n) {
            // 현재 시간까지 들어온 작업 PQ에 추가
            while (idx < n && jobs[idx][0] <= time) {
                pq.add(new Program(jobs[idx][0], jobs[idx][1]));
                idx++;
            }

            if (pq.isEmpty()) {
                // 실행 가능한 작업이 없으면 다음 작업의 요청 시각으로 점프
                time = jobs[idx][0];
            } else {
                Program cur = pq.poll();
                time += cur.workTime;
                answer += time - cur.requestTime; // 응답 시간 = 완료시각 - 요청시각
                count++;
            }
        }

        return answer / n;
    }
}