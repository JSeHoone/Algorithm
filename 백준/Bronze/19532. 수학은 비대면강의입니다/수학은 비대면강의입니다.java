import java.io.*;
import java.util.*;

/*
* ax + by = c
* dx + ey = f
*
* x = (ec - bf) / (ae - bd)
* y = (f - dx) / e
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // a b c d e f
        // 0 1 2 3 4 5
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int a = input[0], b = input[1], c = input[2];
        int d = input[3], e = input[4], f = input[5];

        int parent = a*e - b*d;
        int x = (e*c - b*f) / parent;
        int y = (a * f - c * d) / parent;

        System.out.println(x + " " + y);


    }


}
