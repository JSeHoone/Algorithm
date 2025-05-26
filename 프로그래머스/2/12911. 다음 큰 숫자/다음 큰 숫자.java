class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String convertBinary = Integer.toBinaryString(n);
        String a = convertBinary.replace("0", "");    
        
        boolean flag = true;
        while (flag) {
            int target = ++n;
            String convertTargetToBinary = Integer.toBinaryString(target);
            String b = convertTargetToBinary.replace("0", "");
            
            if (a.length() == b.length()) {
                answer = target;
                flag = false;
                break;
            }
        }
        
        return answer;
    }
}