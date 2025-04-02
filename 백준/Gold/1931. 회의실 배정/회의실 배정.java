import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int meetingCount = Integer.parseInt(br.readLine());
        int[][] scheduledMeeting = new int[meetingCount][2];
        
        for (int i = 0; i < meetingCount; i++) {
            int[] meetingTime = new int[2];
            String[] time = br.readLine().split(" ");
            // start time
            meetingTime[0] = Integer.parseInt(time[0]);
            // end time 
            meetingTime[1] = Integer.parseInt(time[1]);
            
            // append schemduledMeeting
            scheduledMeeting[i] = meetingTime;
        }
        
        // sort meeting time
        Arrays.sort(scheduledMeeting, (a,b) -> {
            int compare = Integer.compare(a[1], b[1]);
            if (compare == 0) {
                return Integer.compare(a[0], b[0]);
            }
            return compare;
        });
        
        // 첫 인자를 먼저 넣고 시작
        int endTime = scheduledMeeting[0][1];
        int answer = 1;
        // count answer
        for (int i =1; i < meetingCount; i++) {
            int startTime = scheduledMeeting[i][0];
            if (startTime < endTime) {
                continue;
            }
            endTime = scheduledMeeting[i][1];
            answer++;
        }
        
        System.out.print(answer);
        
    }
}