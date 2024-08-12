import java.util.stream.LongStream;
class Solution {
    public long solution(int a, int b) {        
        long answer = 0;
        int max = a > b ? a : b;
        int min = a > b ? b : a;
        for(int i = min; i <= max; i++){
            answer += i;
        }
        // answer = LongStream.range(min, max + 1).sum();
        return answer;
    }
}