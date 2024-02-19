import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String s = Integer.toString(n, k);
        String[] split = s.split("0");
        
        for(String sp : split){
            if(sp.isEmpty() || Long.parseLong(sp) <= 1) continue;
            if(dicimal(Long.parseLong(sp))){
                answer++;
            }
        }
        return answer;
    }
    public boolean dicimal(long num){
        for (int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}


// import java.util.*;
// class Solution {
//     public int solution(int n, int k) {
//         int answer = 0;
//         // 진법 변환해서 배열이 비어있거나 1보다 작거나 같으면 패스
//         // 소수인지 판별해서 answer 증가
//         String s = Integer.toString(n, k);
//         String[] split = s.split("0");

//         for(String sp : split){
//             if(sp.isEmpty() || Long.parseLong(sp) <= 1) continue;
//             if(decimal(Long.parseLong(sp))) answer++;
//         }
        
//         return answer;
//     }
    
//     public boolean decimal(long num){
//         for(int i = 2; i<= Math.sqrt(num); i++){
//             if(num%i == 0) return false;
//         }
//         return true;
//     }
// }