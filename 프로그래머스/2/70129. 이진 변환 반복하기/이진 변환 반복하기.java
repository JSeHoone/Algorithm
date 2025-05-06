class Solution {
    private int convertCount;
    private int removeZeroCount;
    public int[] solution(String s) {
        int[] answer = new int[2];

        convertCount = 0;
        removeZeroCount = 0;
        calculate(s);

        answer[0] = convertCount;
        answer[1] = removeZeroCount;
        return answer;

    }

    private void calculate(String binary) {
        if (binary.equals("1")) {
            return;
        }

        // 0을 제거하는
        StringBuilder sb = new StringBuilder();
        for (char num : binary.toCharArray()) {
            if (num == '1') {
                sb.append("1");
            } else {
                removeZeroCount++;
            }
        }

        // 길이를 다시 2진수로 변환
        int numLength = sb.length();
        String newBinary = Integer.toBinaryString(numLength);
        convertCount++;
        calculate(newBinary);
    }
    
    
}