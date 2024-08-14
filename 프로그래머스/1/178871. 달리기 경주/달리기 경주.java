import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < players.length; i++){
            map.put(players[i], i);
        }
        
        for(String calling : callings){
            int loc = map.get(calling);
            String temp = players[loc - 1];
            players[loc - 1] = calling;
            players[loc] = temp;
            map.put(calling, loc - 1);
            map.put(temp, loc);
        }
        return players;
    }
}