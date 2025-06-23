import com.sun.jdi.IntegerValue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    private static int N;
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        int[] temps = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int index = K;
        int dateTemp = 0;
        for (int i = 0; i < index; i++) {
            dateTemp += temps[i];
        }
        int maxTemp = dateTemp;


        for (int i =K; i <N; i++) {
            dateTemp = dateTemp - temps[i -K] + temps[i];
            if (maxTemp < dateTemp) {
                maxTemp = dateTemp;
            }
        }
        System.out.println(maxTemp);
    }
}
