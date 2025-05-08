import java.io.*;
import java.util.*;


public class Main {
    private static int N;
    private static int target;
    private static int H;
    private static int[] woods;
    private static int maxLength;
    private static int minLength;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        target = Integer.parseInt(input[1]);

        // 정렬
        woods = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(woods);

        // init max,min length
        maxLength = woods[N-1];
        minLength = 0;


        while (minLength <= maxLength) {
            int cutterH = (maxLength + minLength) / 2 ;
            long woodLength = 0;
            for (int wood : woods) {
                if (wood > cutterH) {
                    woodLength += wood - cutterH;
                }
            }

            if (woodLength >= target) {
                H = cutterH;
                minLength = cutterH + 1;
            } else {
                maxLength = cutterH - 1;
            }
        }

        System.out.println(H);
    }
}
