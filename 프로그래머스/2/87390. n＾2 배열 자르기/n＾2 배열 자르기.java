class Solution {
    public int[] solution(int n, long left, long right) {
        int result = (int)(right - left + 1);
        int[] answer = new int[result];
        // left, right n으로 나눠 n2[몫][나머지] 
        // 몫과 나머지 중 큰 수 + 1 값이 해당 위치 값
        
        long a = 0;
        long b = 0;
        for(int i = 0; i < result; i++){
            a = left/n;    
            b = left%n;     
            answer[i] = (int)Math.max(a,b) + 1;
            left++;
        }
        
        return answer;
    }
}