class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] numbers = s.split(" ");
        
        int min = Integer.parseInt(numbers[0]);
        int max = Integer.parseInt(numbers[0]);
        
        for (int i = 1; i < numbers.length; i++) {
            int number = Integer.parseInt(numbers[i]);
            
            if (min > number) {
                min = number;
            } else if (max < number) {
                max = number;
            }
        }
        
        answer = min + " " + max;
        return answer;
    }
}