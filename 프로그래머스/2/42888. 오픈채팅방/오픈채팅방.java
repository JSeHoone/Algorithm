/*
유저 관리 자료구조
{
    uuid : name
}
순서 저장 자료구조
[[uuid, ENTER], [uuid, ENTER], [uuid ,LEAVE]]

*/

import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        int N = record.length;
        
        Map<String, String> userInfo = new HashMap<>();
        List<String[]> commandSequence = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            String[] info = record[i].split(" ");
            String command = info[0];
            String uid = info[1];
            
             // 유저 이름 업데이트
            if (command.equals("Enter") || command.equals("Change")) {
                String userName = info[2];
                userInfo.put(uid, userName);
            }

            // 메시지 순서 저장 (Enter, Leave만)
            if (command.equals("Enter") || command.equals("Leave")) {
                commandSequence.add(new String[]{uid, command});
            }
        }
        
        
        // 출력
        String[] answer = new String[commandSequence.size()];
        for (int i = 0; i < commandSequence.size(); i++) {
            String[] info = commandSequence.get(i);
            String uid = info[0];
            String command = info[1];
            String userName = userInfo.get(uid);
            
            String message;
            if (command.equals("Enter")) {
                message = userName+"님이 들어왔습니다.";
            } else {
                message = userName+"님이 나갔습니다.";
            }
            answer[i] = message;
        }
        
        
        return answer;
    }
}