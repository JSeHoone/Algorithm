/*

1. LZW 압축 메서드 정의
1-1. 사전 초기화
1-2. 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다.
1-3. w에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거
1-4. 입력이 되지 않은 글자가 남아있다면(c), w+c에 해당하는 단어를 사전에 등록한다.

 
*/
import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = lzwPackaging(msg);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public List<Integer> lzwPackaging(String word) {
        Map<String,Integer> dict = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // 2-1. 사전 초기화
        for (int i = 0; i < 26; i++) {
            String alphabet = String.valueOf((char) (65+i));
            dict.put(alphabet, i+1);
        }

        int pointer = 0;
        int dictIndex = 27; // 다음에 추가할 index

        // 2-2 ~ 2-4
        while (pointer < word.length()) {
            String w = String.valueOf(word.charAt(pointer));
            int next = pointer + 1;

            // w에 가장 긴 문자열 찾기
            while (next <= word.length() && dict.containsKey(word.substring(pointer, next))) {
                w = word.substring(pointer, next);
                next++;
            }

            // 2-3. w의 색인 번호 출력
            result.add(dict.get(w));

            // 2-4. 새로운 단어 (w + c) 추가 (단, 범위 체크)
            if (next <= word.length()) {
                String newWord = word.substring(pointer, next);
                dict.put(newWord, dictIndex++);
            }

            // w만큼 이동
            pointer += w.length();
        }

        return result;
    }

}