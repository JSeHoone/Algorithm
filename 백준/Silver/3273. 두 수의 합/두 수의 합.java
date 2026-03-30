import java.util.*;
import java.io.*;

/*
투 포인터
*/
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(br.readLine());

        // two pointer
        // step 1. sort numbers
        Arrays.sort(numbers);

        // step 2. init two pointer
        int left = 0;
        int right = N-1;

        // step 3. find combination
        int answer = 0;
        while (left != right) {
            int sumNumber = numbers[left] + numbers[right];

            if (target == sumNumber) {
                answer++;
                left++; // 값이 같은 경우에 index를 더해주지 않으면 계속 같은 index로 OOM이 발생
            } else if (target > sumNumber) {
                left++;
            } else {
                right--;
            }
        }

        // step 4. output answer
        System.out.println(answer);
    }
}