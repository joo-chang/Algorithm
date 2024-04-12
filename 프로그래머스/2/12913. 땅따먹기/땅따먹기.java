class Solution {
    /*
    소요 시간 : 50분
    풀이 : 다음 행은 같은 열을 밟을 수 없다.
          DP 문제
          같은 열을 제외한 다음 행의 값 중 더했을 때 최대 값을 저장하는 방식
          3중 for문? 한 행당 9번만 돌기 때문에 괜찮을 듯? 9n?
          dp[i][j] = Math.max(dp[i][j], land[i-i][k] + land[i][j]);
          j == k continue;
    */
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][land[0].length];
        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];
        for(int i = 1; i < land.length; i++){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 4; k++){
                    if(j==k) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + land[i][j]);
                }
            }
        }
        for(int n : dp[land.length - 1]){
            answer = Math.max(answer, n);
        }
        return answer;
    }
}