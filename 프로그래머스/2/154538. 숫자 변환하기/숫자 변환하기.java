import java.util.*;
class Solution {
    /*
    소요 시간 : 90분
    풀이 : dp 이용하기
    메모이제이션으로 최소 횟수 찾기
    */
    
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        Arrays.fill(dp, y);
        bottomUp(x, y, n, dp);
        return dp[y] == y ? -1 : dp[y];
    }
    
    void bottomUp(int x, int y, int n, int[] dp){
        dp[x] = 0;
        for(int i = x; i <= y; i++){
            if(dp[i] == y) continue;
            if(i + n <= y){
                dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
            }
            if(i * 2 <= y){
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            }
            if(i * 3 <= y){
                dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
            }        
        }
    }
}