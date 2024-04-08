import java.util.*;
class Solution {
//     List<String> list;
//     int[] loc;
//     public int solution(String dirs) {
//         int answer = 0;
//         list = new ArrayList<>();
//         loc = new int[] {0,0};
                
//         for(int i = 0; i < dirs.length(); i++){
//             Character c = dirs.charAt(i);
//             if(move(c)) answer++;
//         }
//         return answer;
//     }
    
//     boolean move(Character c){
//         System.out.println(loc[0] +""+ loc[1] +"" + c);
//         if(c == 'U'){
//             if(loc[1] + 1 > 5) return false;
//             if(list.contains(loc[0] +""+ loc[1] +""+ loc[0] +""+ (loc[1] + 1))){
//                 loc[1]++;
//                 return false;
//             }
//             list.add(loc[0] +""+ loc[1] +""+ loc[0] +""+ (loc[1] + 1));
//             list.add(loc[0] +""+ (loc[1] + 1) +""+ loc[0] +""+ loc[1]);
//             loc[1]++;
//         }else if (c == 'D'){
//             if(loc[1] - 1 < -5) return false;
//             if(list.contains(loc[0] +""+ loc[1] +""+ loc[0] +""+ (loc[1] - 1))){
//                 loc[1]--;
//                 return false;
//             }
//             list.add(loc[0] +""+ loc[1] +""+ loc[0] +""+ (loc[1] - 1));
//             list.add(loc[0] +""+ (loc[1] - 1) +""+ loc[0] +""+ loc[1]);
//             loc[1]--;
//         }else if (c == 'R'){
//             if (loc[0] + 1 > 5) return false;
//             if(list.contains(loc[0] +""+ loc[1] +""+ (loc[0] + 1) +""+ loc[1])){
//                 loc[0]++;
//                 return false;
//             }
//             list.add(loc[0] +""+ loc[1] +""+ (loc[0] + 1) +""+ loc[1]);
//             list.add((loc[0] + 1)+""+ loc[1] +""+ loc[0] +""+ loc[1]);
//             loc[0]++;
//         }else if (c == 'L'){
//             if(loc[0] - 1 < -5) return false;
//             if(list.contains(loc[0] +""+ loc[1] +""+ (loc[0] - 1) +""+ loc[1])){
//                 loc[0]--;
//                 return false;
//             }
//             list.add(loc[0] +""+ loc[1] +""+ (loc[0] - 1) +""+ loc[1]);
//             list.add((loc[0] - 1)+""+ loc[1] +""+ loc[0] +""+ loc[1]);
//             loc[0]--;
//         }
        
//         return true;
//     }
    /*
    소요 시간 : 
    풀이 : 이동할 때마다 양방향 리스트에 넣기
    리스트에 존재하는지 체크
    개수 증가
    */
    
    public int solution(String dirs) {
        int answer = 0;
        int[] loc = {0, 0};
        
        char[] c = {'U', 'D', 'L', 'R'};
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        
        List<String> list = new ArrayList<>();
        for(int i = 0; i < dirs.length(); i++){
            char d = dirs.charAt(i);
            for(int j = 0; j < 4; j++){
                if(d == c[j]){
                    if(check(loc[0] + dy[j], loc[1] + dx[j])) break;
                    if(!list.contains("" +loc[0] + loc[1] + (loc[0]+dy[j]) + (loc[1]+dx[j]))){
                        list.add("" + loc[0] + loc[1] + (loc[0]+dy[j]) + (loc[1]+dx[j]));
                        list.add("" + (loc[0]+dy[j]) + (loc[1]+dx[j]) +loc[0] + loc[1]);
                        answer++;
                    }
                    loc[0] += dy[j];
                    loc[1] += dx[j];
                    break;
                }
            }
        }
        return answer;
    }
    boolean check(int y, int x){
        return y < -5 || x < -5 || y > 5 || x > 5;
    }
}