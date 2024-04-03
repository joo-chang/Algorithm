import java.util.*;
class Solution {
    static List<String> list;
    static String[] v = {"A", "E", "I", "O", "U"};
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        dfs("", 0);
        return list.indexOf(word);
    }
    
    public void dfs(String w, int depth){
        list.add(w);
        if(depth == 5) return;
        
        for(int i = 0; i < 5; i++){
            dfs(w + v[i], depth + 1);
        }
        
    }
}
