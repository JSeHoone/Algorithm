import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] array = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int M = Integer.parseInt(br.readLine());
        Integer[] query = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        
        // 정렬
        Arrays.sort(array);
        
        StringBuilder response = new StringBuilder();
        for (int q : query) {
            int answer = binarySearch(N, array, q);
            response.append(answer).append("\n");
        }
        
        System.out.print(response);
       
    }
    private static int binarySearch(int N, Integer[] array, int k) {
        int start = 0;
        int end = N-1;
        
        while (start <= end) {
            int mid = (start+end) / 2;
            if (array[mid] == k) {
                return 1;
            }
            
            if (array[mid] < k) {
                start = mid + 1;
            } else {
                end = mid -1;
            }            
        }
        
        return 0;
        
    }
}