import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        HashSet<String> set = new HashSet<>();
        
        int[] answer = new int[id_list.length];
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();
        
        for(String s : report){
            set.add(s);
        }
        // 초기값 세팅
        for(String id : id_list){
            map.put(id, new ArrayList<>());
        }
        // 누구한테 신고를 받았는지
        set.forEach(r -> {
            String[] repo = r.split(" ");
            map.get(repo[1]).add(repo[0]);
        });
        
        // 정지된 유저 찾아서 신고한 유저 cnt 증가
        map.forEach((key, value) -> {
            if(value.size() >= k){
                for(String v : value){
                    result.put(v, result.getOrDefault(v, 0) + 1);
                }
            }
        });
        
        for(int i = 0; i < id_list.length; i++){
            answer[i] = result.getOrDefault(id_list[i], 0);
        }
        
        return answer;
    }
}