import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Grade Map
        Map<String, Float> gradeMap = Map.of(
                "A+", 4.5f,
                "A0", 4.0f,
                "B+", 3.5f,
                "B0", 3.0f,
                "C+", 2.5f,
                "C0", 2.0f,
                "D+", 1.5f,
                "D0", 1.0f,
                "F", 0.0f
        );
        
        // calculate
        float totalCredit = 0.0f;
        float totalGrade = 0.0f;
        
        for (int i = 1; i <= 20; i++) {
            String[] subject = br.readLine().split(" ");
            float credit = Float.parseFloat(subject[1]);
            String grade = subject[2];
            
            if (grade.equals("P")) {
                continue;
            } else {
                float convertGrade = gradeMap.get(grade);
                
                // 학점 x 과목 평점
                totalGrade += (credit * convertGrade);
                totalCredit += credit;
            }
        }
        
        System.out.printf("%f", totalGrade/totalCredit);
    }
}