import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String word = br.readLine();
        int index = Integer.parseInt(br.readLine());
        
        System.out.print(word.charAt(index-1));
    }
}