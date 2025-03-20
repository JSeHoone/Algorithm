import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] listA = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        
        // sort
        Arrays.sort(listA);
        
        int M = Integer.parseInt(br.readLine());
        Integer[] listB = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        
        for (int unit : listB) {
            int findIndex = Arrays.binarySearch(listA, unit);
            if (findIndex >= 0) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}