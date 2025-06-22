import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new ArrayList<>(cacheSize);
        
        if (cacheSize == 0) {
            return 5 * cities.length;
        }
        
        for (String city : cities) {
            city = city.toLowerCase();
            
            if (cache.contains(city)) {
                answer += 1;
                cache.remove(city);
                cache.add(city);
            } else {
                answer += 5;
                if (cache.size() >= cacheSize) {
                    cache.remove(0); 
                }
                cache.add(city);
            }
        }
        
        return answer;
    }
}
