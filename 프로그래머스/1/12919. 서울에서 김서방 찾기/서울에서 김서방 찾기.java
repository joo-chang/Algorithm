import java.util.*;
class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(String s : seoul){
            if(s.equals("Kim")){
                // return "김서방은 " + cnt + "에 있다";
                return sb.append("김서방은 ").append(cnt).append("에 있다").toString();
            }
            cnt++;
        }
        return answer;
    }
}