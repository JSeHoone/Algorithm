import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        List<String> rows = new ArrayList<>();
        int maxLength = 0;
        
        for (int i = 1; i <= 5; i++) {
            String row = br.readLine();
            if (row.length() > maxLength) {
                maxLength = row.length();
            }
            rows.add(row);
        }
        
        StringBuilder response = new StringBuilder();
        for (int i = 0; i < maxLength; i++) {
            for (String row : rows) {
                if (i < row.length()) {
                    response.append(row.charAt(i));
                }
            }
        }
        
        System.out.println(response.toString());
    }
}
