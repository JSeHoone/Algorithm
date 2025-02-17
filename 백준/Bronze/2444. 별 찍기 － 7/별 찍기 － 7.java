import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Integer input = Integer.parseInt(br.readLine());        
        Integer loopCount = (input*2) - 1;
        Integer starCount = 1;
        
        for (int i = 1; i <= loopCount; i++) {
            if (i < input) {
                Integer startIndex = input - i;
                String emptyZone = " ".repeat(startIndex);
                String star = "*".repeat(starCount);
                starCount += 2;
                System.out.println(emptyZone + star);
            } else if (i == input) {
                String star = "*".repeat(starCount);
                starCount -= 2;
                System.out.println(star);
            } else {
                Integer startIndex = i - input;
                String emptyZone = " ".repeat(startIndex);
                String star = "*".repeat(starCount);
                starCount -= 2;
                System.out.println(emptyZone + star);
            }
        }
    }
}