import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Map<String, Integer>> giftMap = new HashMap<>();
        // 선물 지수
        Map<String, Integer> giftInfo = new HashMap<>();
        // 받는 선물 개수
        Map<String, Integer> resultGift = new HashMap<>();
        
        // 초기화
        for(String friend : friends){
            giftMap.put(friend, new HashMap<>());
            giftInfo.put(friend, 0);
            resultGift.put(friend, 0);
        }
        
        // 값 세팅
        for(String gift : gifts){
            String[] split = gift.split(" ");
            giftMap.get(split[0]).put(split[1], giftMap.get(split[0]).getOrDefault(split[1], 0) + 1);
            giftInfo.put(split[0], giftInfo.get(split[0]) + 1);
            giftInfo.put(split[1], giftInfo.get(split[1]) - 1);
        }
        
        for(String give : friends){
            for(String rec : friends){
                if(!give.equals(rec)){
                    if(giftMap.get(give).getOrDefault(rec, 0) > giftMap.get(rec).getOrDefault(give, 0)){
                        resultGift.put(give, resultGift.get(give) + 1);
                    }else if(giftMap.get(give).getOrDefault(rec, 0) == giftMap.get(rec).getOrDefault(give, 0) && giftInfo.get(give) > giftInfo.get(rec)){
                        resultGift.put(give, resultGift.get(give) + 1);
                    }    
                }
                
            }
        }
        
        return Collections.max(resultGift.values());
    }
}