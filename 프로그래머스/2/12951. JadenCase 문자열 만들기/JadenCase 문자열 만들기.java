class Solution {
    public String solution(String s) {
		String answer = "";
        s = s.toLowerCase();
		String[] sSplit = s.split(" ");
		for (int i = 0; i < sSplit.length; i++) {
            if(sSplit[i].length() == 0) answer += " "; 
            else{
                answer += sSplit[i].substring(0, 1).toUpperCase() + sSplit[i].substring(1) + " ";    
            }
			
		}
        //원래 문자열 마지막이 공백일 경우 그대로 answer 반환
        if(s.substring(s.length() -1, s.length()).equals(" ")) return answer;
        //마지막에 공백이 더해져서 그 공백을 제외한 answer값 반환
        return answer.substring(0, answer.length() - 1);
	}
}