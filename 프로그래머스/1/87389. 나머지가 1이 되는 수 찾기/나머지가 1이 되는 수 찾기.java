import java.util.stream.IntStream;
class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i =2; i<=n; i++){
            if (n % i == 1) {
                answer = i;
                break;
            }
        }
        // IntStream.range(2, n+1).filter(x -> n % x == 1).findFirst().orElse(0);
        return answer;
    }
}