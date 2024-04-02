class Solution {
//     public String solution(int n, int t, int m, int p) {
//         String answer = "";
//         // 1부터 진법으로 변환해서 StringBuilder에 추가 하는데, 그 길이가 m * t 보다 클 때 까지
//         // p번째 뽑고 m씩 더해서 t번 뽑기
//         StringBuilder sb = new StringBuilder();
//         int count = 0;
//         while(true){
//             if(sb.length() > t * m) break;
//             sb.append(Integer.toString(count, n));
//             count++;
//         }
        
//         for(int i = 0; i < t; i++){
//             // p 번째 값 불러오고, m 번씩 더하면서 answer 값 도출 (0번째 부터니까 -1)
//             answer += sb.charAt(p + i * m - 1);
//         }
        
//         return answer.toUpperCase();
//     }
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(true){
            if(sb.length() > t * m) break;
            sb.append(Integer.toString(count, n));
            count++;
        }
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < t; i++){
            ans.append(sb.charAt(i * m + p - 1));
        }
        return ans.toString().toUpperCase();
    }
}