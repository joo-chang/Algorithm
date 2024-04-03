import java.util.*;
class Solution {
//     static String[] v = {"A", "E", "I", "O", "U"};
//     public int solution(String word) {
//         int answer = 0;
//         List<String> list = new ArrayList<>();
//         dfs(list, "", 0);
//         // for(int i = 0; i < list.size(); i++){
//         //     if(list.get(i).equals(word)){
//         //         answer = i;
//         //         break;
//         //     }
//         // }
//         return list.indexOf(word);
//     }
    
//     public void dfs(List<String> list, String w, int depth){
//         list.add(w);
//         if(depth == 5) return;
        
//         for(int i = 0; i < 5; i++){
//             dfs(list, w + v[i], depth + 1);
//         }
        
//     }
    
    private StringBuilder sb = new StringBuilder();
    private char[] v = {'A','E','I','O','U'};
    private boolean flag = false;
    private int answer = 0;

    private void dfs(String word) {
        if(word.equals(sb.toString())) {
            flag = true;
            return;
        }
        if(sb.length() == 5) return;

        for(int i=0; i<5; i++) {
            answer++;
            sb.append(v[i]);
            dfs(word);
            sb.deleteCharAt(sb.length()-1);

            if(flag) return;
        }
    }

    public int solution(String word) {
        dfs(word);
        return answer;
    }
}
