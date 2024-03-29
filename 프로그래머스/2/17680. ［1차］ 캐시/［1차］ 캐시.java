import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> cache = new LinkedList<>();
        if(cacheSize == 0){
            return cities.length * 5;
        }
        for(String c : cities){
            String city = c.toLowerCase();
            
            if(cache.contains(city)){
                answer++;
                cache.remove(city);
                cache.add(city);
            }else{
                if(cache.size() < cacheSize){
                    answer += 5;
                    cache.add(city);
                }else{
                    answer += 5;
                    cache.poll();
                    cache.add(city);
                }
            }
        }
        return answer;
    }
}