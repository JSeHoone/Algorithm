class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder convert = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        // 충분한 길이 확보
        for (int i = 0; convert.length() <= t * m; i++) {
            convert.append(Integer.toString(i, n));
        }

        // 튜브 차례에 해당하는 문자만 추출
        for (int i = p - 1; i < m * t; i += m) {
            answer.append(convert.charAt(i));
        }
        return answer.toString().toUpperCase();
    }
}
