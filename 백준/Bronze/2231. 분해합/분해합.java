import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N =  br.readLine();
        int response = calculateSum(N);

        System.out.println(response);


    }

    public static int calculateSum(String N) {
        // 각 자리수는 최대 9까지만 가능하다.
        // 받은 숫자 N의 자리수 만큼 9를 곱한 값에서 for문을 시작하면 ?
        // 최대 999,999 (54)번만 돌면 된다.

        // 최대 숫자
        int convertN = Integer.parseInt(N);
        int maxLoop = (N.length() * 9);

        int response = 0;

        for (int i = 1; i <= maxLoop; i++) {
            int unitTarget = convertN - i;
            String convertString = String.valueOf(unitTarget);

            for (char num : convertString.toCharArray()) {
                unitTarget += (num - '0');
            }
            
            if (unitTarget == (convertN)) {
                response = convertN -i;
            }
        }

        return response;
    }
}
