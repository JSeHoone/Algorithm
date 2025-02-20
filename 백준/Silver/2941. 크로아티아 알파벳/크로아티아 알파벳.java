import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] dict = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String input = br.readLine();
        
        for (int i = 0; i < dict.length; i++) {
            if (input.contains(dict[i])) {
                input = input.replace(dict[i], "!");
            }
        }
        
        System.out.print(input.length());
    }
}