import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.ArrayDeque;

/*
Stack 객체는 오래된 클래스라 synchronized 오버헤드가 많다고 합니다.
- Vector를 상속하고 있어서 모든 메서드에 불필요한 동기화 비용이 들어가기 때문 !
- 단일 스레드 환경에서는 완전 비효율적 !

Deque는 Stack 객체보다 빠르고, push/pop 성능이 우수하다고 합니다.
- 내부 구조는 배열 + 원형 버퍼를 사용한다고 합니다.
*/ 

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            String command = inputs[0];
            
            switch (command) {
                case "push" :
                    int value = Integer.parseInt(inputs[1]);
                    stack.push(value);
                    break;

                case "pop" :
                    // if empty
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack.pop());
                    }
                    break;
                    
                case "size" :
                    System.out.println(stack.size());
                    break;
                    
                case "empty" :
                    System.out.println(stack.isEmpty() ? 1 : 0);
                    break;
                    
                case "top" :
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack.peek());
                    }
                    break;
                    
            }
        } 
    }
}