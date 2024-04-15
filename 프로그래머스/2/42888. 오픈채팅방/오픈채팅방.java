import java.util.*;
class Solution {
    /*
    소요 시간 : 20분
    풀이 : enter 체크하면서 맵에 아이디랑 닉네임 저장해두고, 이미 있으면 갱신, change 나와도 갱신
    다시 전체 돌면서 아이디 별로 값 찾아서 응답
    */
    public String[] solution(String[] record) {
        String[] answer = {};
        List<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for(String r : record){
            String[] reco = r.split(" ");
            if(reco[0].equals("Enter") || reco[0].equals("Change")){
                map.put(reco[1], reco[2]);
            }
        }
        
        for(String r : record){
            String[] reco = r.split(" ");
            if(reco[0].equals("Enter")){
                list.add(map.get(reco[1]) + "님이 들어왔습니다.");
            }else if(reco[0].equals("Leave")){
                list.add(map.get(reco[1]) + "님이 나갔습니다.");
            }
        }
        answer = list.toArray(new String[list.size()]);
        return answer;
    }
}