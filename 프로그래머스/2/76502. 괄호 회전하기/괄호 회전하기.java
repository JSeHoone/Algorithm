class Solution {
    public int solution(String s) {
        int answer = 0;
        
        if (checkString(s)) {
            answer += 1;
        }
        
        for (int i = 0; i < s.length() - 1; i++) {
            s =  s.substring(1) + s.charAt(0);
            
            if (checkString(s)) {
               answer += 1; 
            }
        
        }
        
        
        
        return answer;
    }
    
    private boolean checkString(String s) {
        String a = "";
        for (char unit : s.toCharArray()) {
            a += unit;
            
            if (a.contains("[]")) {
                a = a.replace("[]","");
            } else if (a.contains("()")) {
                a = a.replace("()","");
            } else if (a.contains("{}")) {
                a = a.replace("{}","");
            }
        }
        if (a.length() == 0) {
            return true;
        }
        
        return false;
    }
}