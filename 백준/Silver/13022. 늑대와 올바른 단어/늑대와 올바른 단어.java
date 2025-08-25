import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(isValidWolf(s) ? 1 : 0);
    }

    private static boolean isValidWolf(String s) {
        int i = 0, n = s.length();
        while (i < n) {
            // 1) w 연속 개수
            int cntW = 0;
            while (i < n && s.charAt(i) == 'w') { cntW++; i++; }
            if (cntW == 0) return false; // 블록은 반드시 w로 시작

            // 2) o cntW개
            for (int k = 0; k < cntW; k++) {
                if (i >= n || s.charAt(i) != 'o') return false;
                i++;
            }
            // 3) l cntW개
            for (int k = 0; k < cntW; k++) {
                if (i >= n || s.charAt(i) != 'l') return false;
                i++;
            }
            // 4) f cntW개
            for (int k = 0; k < cntW; k++) {
                if (i >= n || s.charAt(i) != 'f') return false;
                i++;
            }
        }
        // 끝까지 정확히 소비되면 유효
        return true;
    }
}
