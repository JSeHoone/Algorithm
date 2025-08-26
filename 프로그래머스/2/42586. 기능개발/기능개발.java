import java.lang.Math;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        int[] remainDays = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            
            int remainDay = (int) Math.ceil((double)(100 - progress) / speed);
            remainDays[i] = remainDay;
        }
        
        answer.add(1);
        int index = 0;
        int preProgress = remainDays[0];
        for (int i = 1; i < remainDays.length; i++) {
            if (preProgress >= remainDays[i]) {
                answer.set(index, answer.get(index) + 1);
            } else {
                answer.add(1);
                index++;
                preProgress = remainDays[i];
            }
        }
        
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}