import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;
import java.util.regex.Pattern;


class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        // 교집합 / 합집합 = 자카드 유사도
        // 공집합인 경우에는 1로 정의한다.
        // 다중집합에 대해서 확장 가능, 교집합인 경우에는 Min, 합집합인 경우에는 max를 지원
        // 2글자씩 끊어서 교집합 합집합을 구한다
        // 특수문자가 있는 경우는 무시한다.
        
        // HashSet<String> setA = new HashSet<>();
        List<String> setA = new ArrayList<>();
        makeStringSet(setA, str1);
        
        // HashSet<String> setB = new HashSet<>();
        List<String> setB = new ArrayList<>();
        makeStringSet(setB, str2);
        
        int inter = intersection(setA, setB);
        int uni = union(setA, setB);
        
        if (inter == 0 && uni == 0) {
            return 65536;
        }
    
        int calculate = (int)(( (double) inter / uni ) * 65536);
    
        
        return calculate;
    }
    
    
    private void makeStringSet(List<String> set, String str) {
        for (int i = 0; i < str.length() - 1;  i++) {
            String unit = str.substring(i, i+2).toUpperCase();
            boolean check = Pattern.matches("^[a-zA-Z]*$", unit);
            
            if (check) {
                set.add(unit);
            }
        }
    }
    
    private int intersection(List<String> setA, List<String>setB) {
        
        // 교집합
        int countUnit = 0;
        HashSet<String> used = new HashSet<>();
        for (String unit : setA) {
            if (used.contains(unit)) {
                continue;
            } else {
                long countA = setA.stream().filter(a -> a.equals(unit)).count();
                long countB = setB.stream().filter(a -> a.equals(unit)).count();
                
                long count = Math.min(countA, countB);
                countUnit += count;
                used.add(unit);
            }
            
        }   
        
        return countUnit;
    }
    
    private int union(List<String> setA, List<String> setB) {
        
        // 합집합
        int countUnit = 0;
        HashSet<String> used = new HashSet<>();
        for (String unit : setA) {
            if (used.contains(unit)) {
                continue;
            } else {
                long countA = setA.stream().filter(a -> a.equals(unit)).count();
                long countB = setB.stream().filter(a -> a.equals(unit)).count();
                
                long count = Math.max(countA, countB);
                countUnit += count;
                used.add(unit);
                
            }
        }
        
        for (String unit : setB) {
            if (!used.contains(unit)) {
                used.add(unit);
                long countB = setB.stream().filter(a -> a.equals(unit)).count();
                countUnit += countB;
            }
        }
        
        return countUnit;
        
    }
}