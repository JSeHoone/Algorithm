import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] people = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // sort
        Arrays.sort(people);

        // calculate
        for (int i = 1; i < N; i++) {
            people[i] = people[i-1] + people[i];
        }

        System.out.println(Arrays.stream(people).sum());
        
        
    }
}