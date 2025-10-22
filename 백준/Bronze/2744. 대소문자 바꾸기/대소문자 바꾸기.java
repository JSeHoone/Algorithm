import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        for (char unit : input.toCharArray()) {
            if (unit > 96) {
                System.out.print((char) (unit - 32));
            } else {
                System.out.print((char) (unit + 32));
            }

        }


    }
}
