class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        int cnt = 0;
        for(String s : seoul){
            if(s.equals("Kim")){
                return "김서방은 " + cnt + "에 있다";
            }
            cnt++;
        }
        return answer;
    }
}