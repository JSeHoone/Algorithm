import java.util.*;
import java.lang.*;
import java.io.*;

/*
동전이 오름차순으로 주어지니까 Stack으로 동전을 관리하면 될 것 같아 !
*/
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int target = inputs[1];
        
        // coins 
        Deque<Integer> coins = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            coins.add(Integer.parseInt(br.readLine()));
        }

        // answer
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int coin = coins.pollLast();
            answer += (target / coin);
            target = (target % coin);
        }

        System.out.println(answer);
        
    }
}