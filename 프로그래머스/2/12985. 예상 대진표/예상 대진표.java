class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;
        // a와 b가 같아질 때까지 라운드 진행
        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }
        return answer;
    }
}
