import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int x = 0, y = 0;
        
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < dirs.length(); i++) {
            char command = dirs.charAt(i);
            int nx = x, ny = y;
            String position = "";
            
            switch (command) {
                case 'U' :
                    ny++;
                    break;
                case 'D' :
                    ny--;
                    break;
                case 'R' : 
                    nx++;
                    break;
                case 'L' :
                    nx--;
                    break;
            }
            
            if ( nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                continue;
            }
            
            String a = x + "," + y;
            String b = nx + "," + ny;
            String edgeKey = (a.compareTo(b) < 0) ? (a + "-" + b) : (b + "-" + a);

            visited.add(edgeKey);

            x = nx;
            y = ny;
        }
        
        System.out.print(visited);
        return visited.size();
    }
}