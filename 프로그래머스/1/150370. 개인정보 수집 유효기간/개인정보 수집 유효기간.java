import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
class Solution {
    public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
		ArrayList<Integer> answer = new ArrayList<>();
        LocalDate todate = LocalDate.parse(today, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        HashMap<String, Integer> exp = new HashMap<>();
        
        for(String t : terms){
            String[] s = t.split(" ");
            exp.put(s[0], Integer.parseInt(s[1]));
        }
        
        for(int i = 0; i < privacies.length; i++){
            String[] p = privacies[i].split(" ");
            LocalDate date = LocalDate.parse(p[0], DateTimeFormatter.ofPattern("yyyy.MM.dd")).plusMonths(exp.get(p[1]));
            if(todate.compareTo(date) >= 0){
                answer.add(i + 1);
            }
        }
        
        Collections.sort(answer);
        
		return answer;
	}

}