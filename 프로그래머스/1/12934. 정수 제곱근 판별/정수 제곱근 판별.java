class Solution {
    public long solution(long n) {
        long answer = -1;
        long num = 0;
        while(Math.pow(num, 2) <= n){
            if(Math.pow(num, 2) == n){
               return (num + 1) * (num + 1);
            }
            num++;
        }
        return answer;
    }
}