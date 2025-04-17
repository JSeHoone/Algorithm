import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<int[]> list = new ArrayList<>(N);
        for (int i = 1; i <= N; i++) {
            list.add(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;

        while (!list.isEmpty()) {
            int[] cur = list.remove(idx);
            sb.append(cur[0]).append(' ');

            if (list.isEmpty()) break;

            int k = cur[1];
            int size = list.size();
            idx = (idx + (k > 0 ? (k - 1) : k)) % size;
            if (idx < 0) idx += size;
        }

        System.out.println(sb);
    }
}
