import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        Map<String, String> people = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            String[] commands = br.readLine().split(" ");
            
            if (commands[1].equals("enter")) {
                people.put(commands[0], commands[1]);
            } else {
                if (people.containsKey(commands[0])) {
                    people.remove(commands[0]);
                }
            }
        }
        
        // 사전 순의 역순으로 출력을 해야 함.
        List<String> peopleList = new ArrayList<>(people.keySet());
        peopleList.sort(Comparator.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for (String person : peopleList) {
            sb.append(person).append("\n");
        }
        
        System.out.println(sb);
    }
}