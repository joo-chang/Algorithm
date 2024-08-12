class Solution {
    public int solution(int num) {
        int answer = 0;
        long n = num;
        for(int i = 0; i <= 500; i++){
            if(n == 1) break;
            if(i == 500) return -1;
            if(n % 2 == 0){
                n /= 2;
                answer++;
            } else {
                n = n * 3 + 1;  
                answer++;
            } 
        }
        return answer;
    }
}