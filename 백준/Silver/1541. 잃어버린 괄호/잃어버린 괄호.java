import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // minus split
        String[] minusSplit = br.readLine().split("-");

        Integer result = 0;
        if (minusSplit.length > 1) {
            for (int i = 0; i < minusSplit.length; i++) {
                String section = minusSplit[i];
                if (i ==0) {
                    if (!section.matches("[+-]?\\d*(\\.\\d+)?")) {
                        int sumNumber = plusCalculate(section);
                        result += sumNumber;
                        continue;
                    } else {
                        result += Integer.parseInt(section);
                    }
                    continue;
                }

                // 숫자가 아닌경우 (즉, + 연산자가 있는 경우)
                if (!section.matches("[+-]?\\d*(\\.\\d+)?")) {
                        int sumNumber = plusCalculate(section);
                        result -= sumNumber;
                } else {
                    result -= Integer.parseInt(section);
                }
            }
        } else {
            int sumNumber = plusCalculate(minusSplit[0]);
            result = sumNumber;
        }


        System.out.print(result);

    }

    public static int plusCalculate(String section) {
        String[] numbers = section.split("\\+");

        int sumNum = 0;
        for(String number : numbers) {
            sumNum += Integer.parseInt(number);
        }

        return sumNum;

    }
}
