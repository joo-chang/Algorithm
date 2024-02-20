import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0; 
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long total = 0;
        for(int i = 0; i < queue1.length; i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            sum1 += queue1[i];
            total += queue1[i] + queue2[i];
        }
        
        if(total % 2 != 0) return -1;
        total /= 2;
        while(true){
            if(answer > (queue1.length + queue2.length) * 2) return -1;
            if(sum1 == total) break;
            else if(sum1 < total){
                sum1 += q2.peek();
                q1.add(q2.poll());
            }else{
                sum1 -= q1.peek();
                q2.add(q1.poll());
            }
            answer++;
        }
        
        return answer;
    }

}