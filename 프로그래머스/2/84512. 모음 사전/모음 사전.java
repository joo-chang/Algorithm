import java.util.*;
class Solution {
    static String[] v = {"A", "E", "I", "O", "U"};
    public int solution(String word) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        dfs(list, "", 0);
        // for(int i = 0; i < list.size(); i++){
        //     if(list.get(i).equals(word)){
        //         answer = i;
        //         break;
        //     }
        // }
        return list.indexOf(word);
    }
    
    public void dfs(List<String> list, String w, int depth){
        list.add(w);
        if(depth == 5) return;
        
        for(int i = 0; i < 5; i++){
            dfs(list, w + v[i], depth + 1);
        }
        
    }
}
