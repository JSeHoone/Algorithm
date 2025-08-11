import java.util.*;

class Solution {
    private static final int SCALE = 65536;

    public int solution(String str1, String str2) {
        Map<String, Integer> a = toBigrams(str1);
        Map<String, Integer> b = toBigrams(str2);

        // 둘 다 공집합이면 1로 정의 (SCALE 반환)
        if (a.isEmpty() && b.isEmpty()) return SCALE;

        int inter = 0, uni = 0;

        // 키 합집합 순회로 교집합/합집합 동시 계산
        Set<String> keys = new HashSet<>(a.keySet());
        keys.addAll(b.keySet());
        for (String k : keys) {
            int ca = a.getOrDefault(k, 0);
            int cb = b.getOrDefault(k, 0);
            inter += Math.min(ca, cb);
            uni   += Math.max(ca, cb);
        }

        return (int) Math.floor((inter * (double) SCALE) / uni);
    }

    private Map<String, Integer> toBigrams(String s) {
        Map<String, Integer> map = new HashMap<>();
        String u = s.toUpperCase();

        for (int i = 0; i < u.length() - 1; i++) {
            char c1 = u.charAt(i);
            char c2 = u.charAt(i + 1);

            // 알파벳 2글자만 유효
            if (isAlpha(c1) && isAlpha(c2)) {
                String key = u.substring(i, i + 2);
                map.merge(key, 1, Integer::sum); // 빈도 1 증가
            }
        }
        return map;
    }

    private boolean isAlpha(char c) {
        return c >= 'A' && c <= 'Z';
    }
}
