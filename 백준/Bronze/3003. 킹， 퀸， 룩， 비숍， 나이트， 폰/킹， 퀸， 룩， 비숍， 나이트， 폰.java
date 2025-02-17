import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        Integer[] convertInteger = Arrays.stream(input).map(Integer::valueOf).toArray(Integer[]::new);
        
        // king 
        System.out.printf("%d ", 1-convertInteger[0]);
        
        // queen
        System.out.printf("%d ", 1-convertInteger[1]);
        
        // rook
        System.out.printf("%d ", 2-convertInteger[2]);
        
        // bishop
        System.out.printf("%d ", 2-convertInteger[3]);
        
        // knight
        System.out.printf("%d ", 2-convertInteger[4]);
        
        // pawn
        System.out.printf("%d ", 8-convertInteger[5]);
    }
}