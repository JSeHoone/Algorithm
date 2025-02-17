import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int wordLength = word.length();
        String reverseWord = "";
        
        for (int i = 1; i <= wordLength; i++) {
            reverseWord += word.charAt(wordLength - i);
        }
        
        if (word.equals(reverseWord)) {
            System.out.print("1");
        } else {
            System.out.print("0");
        }

    }
}