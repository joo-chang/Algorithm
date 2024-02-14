import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 1. 중복 제거
        // 2. 신고 개수 체크
        // 3. 각 유저가 신고한 id 체크하면서 k이상인 애들 count
        // List<String> reportList = new ArrayList<>(new HashSet<>(Arrays.asList(report)));
        
        HashSet<String> set = new HashSet<>();
        
        int[] answer = new int[id_list.length];
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> repoCnt = new HashMap<>();
        List<String> van = new ArrayList<>();
        
        // 중복 제거
        for(String s : report){
            set.add(s);
        }
        // 초기값 세팅
        for(String id : id_list){
            map.put(id, new ArrayList<>());
        }
        // 값 저장
        set.forEach(r -> {
            String[] repo = r.split(" ");
            if(!map.containsKey(repo[0])){
                map.put(repo[0], new ArrayList<>());
            }
            map.get(repo[0]).add(repo[1]);
            repoCnt.put(repo[1], repoCnt.getOrDefault(repo[1], 0) + 1);
        });
        
        // 정지된 id 추출
        repoCnt.forEach((key, value) ->{
            if(value >= k){
                van.add(key);
            }
        });
        
        // result
        for(int i = 0 ; i < id_list.length; i++){
            for(String v : van){
               if(map.get(id_list[i]).contains(v)){
                   answer[i]++;
               } 
            }
        }
        
        return answer;
    }
}