/*
출력하는 명령어
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력 정수가 없는 경우에는 -1출력
size: 큐에 들어있는 정수의 갯수
empty: 큐가 비어있으면 1, 아니면 0
front: 큐의 가장 앞에 있는 정수를 출력한다. 
back: 큐의 가장 뒤에 있는 정수를 출력한다.

입력하는 명령어
push: 숫자를 입력한다.
*/

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        // Deque를 이용해서 Queue를 구현
        Deque<Integer> queue = new ArrayDeque<>();
        
        StringBuilder sb = new StringBuilder();
        for (int i =0; i < N; i++) {
            // push만 length가 2이다.
            String[] inputs = br.readLine().split(" ");
            String command = inputs[0];
            int queueSize = queue.size();
            
            // push인 경우
            if (inputs.length == 2){
                int value = Integer.parseInt(inputs[1]);
                queue.add(value);
            } else {
                switch (command) {
                    case "pop" :
                        if (queueSize == 0) {
                            sb.append(-1).append("\n");
                        } else {
                            sb.append(queue.pollFirst()).append("\n");
                        }
                        break;
                    case "size":
                        sb.append(queueSize).append("\n");
                        break;
                    case "empty":
                        if (queueSize == 0) {
                            sb.append(1).append("\n");
                        } else{
                            sb.append(0).append("\n");
                        }
                        break;
                    case "front":
                        if (queueSize == 0) {
                            sb.append(-1).append("\n");
                        } else {
                            sb.append(queue.peekFirst()).append("\n");
                        }
                        break;
                    case "back":
                        if (queueSize == 0) {
                            sb.append(-1).append("\n");
                        } else {
                            sb.append(queue.peekLast()).append("\n");
                        }
                        break;
                }
            }
        }
        
        System.out.println(sb);
    }
}