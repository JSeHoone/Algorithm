import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int maxValue = 0;
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 1; i <= 9; i++) {
            Integer[] row = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            for (int j = 0; j<9; j++) {
                if (row[j] >= maxValue) {
                    maxValue = row[j];
                    maxRow = i;
                    maxCol = j+1;
                }
            }
        }
        
        System.out.println(maxValue);
        System.out.printf("%d %d", maxRow, maxCol);

    }
}
