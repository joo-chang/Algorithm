import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
class Solution {
    public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
		ArrayList<Integer> answer = new ArrayList<>();
        int todate = getDate(today);
        HashMap<String, Integer> exp = new HashMap<>();
        
        for(String t : terms){
            String[] s = t.split(" ");
            exp.put(s[0], Integer.parseInt(s[1]) * 28);
        }
        
        for(int i = 0; i < privacies.length; i++){
            String[] p = privacies[i].split(" ");
            
            if(todate >= getDate(p[0]) + exp.get(p[1])){
                answer.add(i + 1);
            }
        }
        
        Collections.sort(answer);
        
		return answer;
	}

    private int getDate(String date){
        String[] d = date.split("\\.");
        int year = Integer.parseInt(d[0]) * 12 * 28;
        int month = Integer.parseInt(d[1]) * 28;
        int day = Integer.parseInt(d[2]);
        return year + month + day;
    }
}