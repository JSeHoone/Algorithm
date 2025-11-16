import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list_ = {666,1666,2666,3666,4666,5666,6660,6661,6662,6663,6664,6665,6666,6667,6668,6669,7666,8666,9666};

        if (N <= 19) {
            System.out.println(list_[N-1]);
        } else {
            int next = 10000;
            int M = 19;

            while (true) {
                next++;
                if (String.valueOf(next).contains("666")) {
                    M++;
                }

                if (N == M) {
                    System.out.println(next);
                    break;
                }
            }
        }



    }
}
