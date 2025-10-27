import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            int[] input = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(input[0] + input[1]);
        }


    }
}
