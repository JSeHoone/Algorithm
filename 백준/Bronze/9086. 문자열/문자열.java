import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String testCase = br.readLine();
            String a = "";
            a += testCase.charAt(0);
            a += testCase.charAt(testCase.length()-1);

            System.out.println(a);

        }


    }
}
