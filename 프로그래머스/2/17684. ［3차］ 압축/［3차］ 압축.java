import java.util.*;
class Solution {
//     public int[] solution(String msg) {
//         List<String> dict = new ArrayList<>();
//         List<Integer> ans = new ArrayList<>();
        
//         dict = setDictionary();
//         if(msg.length() <= 1){
//             ans.add(msg.indexOf(msg.charAt(0))+1);
//             return ans.stream().mapToInt(Integer::intValue).toArray();
//         }
//         String w = String.valueOf(msg.charAt(0));
//         String c = String.valueOf(msg.charAt(1));
        
//         // index + 1하기
//         for( int i = 1; i < msg.length(); i++){
//             // 초기 w를 받아, 한 개 더해봐, 있으면 계속 더하다가 없으면 마지막 더한 문자를 c로 세팅
//             // 두개를 더해서 dict에 추가 w가 몇번짼지 answer에 추가 i도 개수만큼 추가
//             // 1. 1개는 무조건 있으니까 2개 없으면 
//             // 2. 마지막 문자 세팅하고, answer에 추가
//             // 3. w를 c로 세팅
//             while(true){
//                 if(dict.contains(w+c)){
//                     w = w + c;
//                     if(i == msg.length() - 1){
//                         ans.add(dict.indexOf(w)+1);
//                         break;
//                     }
//                     c = String.valueOf(msg.charAt(i+1));
//                     i++;
//                     System.out.println(w + " " + c);
//                     continue;
//                 }

//                 ans.add(dict.indexOf(w)+1);
//                 dict.add(w + c);
//                 if(i == msg.length()-1){
//                     ans.add(dict.indexOf(c)+1);
//                     break;
//                 }               
//                 w = c;
//                 c = String.valueOf(msg.charAt(i+1));
//                 break;
//             }
//         }
//         return ans.stream().mapToInt(Integer::intValue).toArray();
//     }
    
//     //초기 세팅
//     public List<String> setDictionary(){
//         List<String> dict = new ArrayList<>();
//         char c = 'A';
//         for(int i = 0; i < 26; i++){
//             dict.add(String.valueOf(c));
//             c++;
//         }
        
        
//         return dict;
//     }
    public int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        char c = 'A';
        int num = 27;
        // 사전 초기 세팅
        for(int i = 1; i <= 26; i++){
            dict.put(String.valueOf(c), i);
            c++;
        }
        
        for(int i = 0; i < msg.length(); i++){
            String word = String.valueOf(msg.charAt(i));
            while(true){
                if(i < msg.length() -1){
                    // 사전에 (word + 다음 글자) 없을 때까지 반복
                    if(dict.containsKey(word + String.valueOf(msg.charAt(i+1)))){
                        word = word + String.valueOf(msg.charAt(i+1));
                        i++;
                    }else{
                        // 없으면 사전에 추가, 현재 단어 번호 저장
                        dict.put(word + String.valueOf(msg.charAt(i+1)), num);
                        num++;
                        ans.add(dict.get(word));
                        break;
                    }    
                }else{
                    // 마지막 글자면 단어 사전 찾아서 저장
                    ans.add(dict.get(word));
                    break;
                }
                
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}