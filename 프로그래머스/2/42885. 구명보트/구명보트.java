import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        // sorting
        Arrays.sort(people);
        
        // two pointer
        int startPoint = 0;
        int endPoint = people.length - 1;
        int count = 0;
        
        while (count != people.length) {
            if (startPoint == endPoint) {
                count++;
                answer++;
                break;
            }
            
            int twoPeople = people[startPoint] + people[endPoint];
            
            if (twoPeople > limit) {
                count++;
                endPoint--;
            } else {
                count += 2;
                endPoint--;
                startPoint++;
            }
            answer++;
        }
        
        return answer;
    }
}