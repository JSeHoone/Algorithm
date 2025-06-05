class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        if (arr.length == 1) {
            return arr[0];
        } 
        
        
        int lcmValue = lcm(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            lcmValue = lcm(lcmValue, arr[i]);
        }
        
        return lcmValue;
    }
    
    private int gcd(int a, int b) {
        int r;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        
        return a;
    }
    
    private int lcm(int a, int b) {
        
        return (a * b) / gcd(a,b);
    }
    
    
}