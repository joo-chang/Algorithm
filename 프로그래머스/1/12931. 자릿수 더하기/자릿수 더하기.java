import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int ten = 10;
        
        while(n > 9){
            answer += n % ten;
            n /= 10;
        }
        answer += n;
        
        return answer;
    }
}