import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        
        // first output
        System.out.println(a + b - c);
        
        StringBuilder ab = new StringBuilder();
        ab.append(a);
        ab.append(b);
        int convertAB = Integer.parseInt(ab.toString());
        
        // second output
        System.out.println(convertAB -c);
        

    }
}