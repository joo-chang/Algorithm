import java.util.*;
class Solution {
//     public int solution(int[] scoville, int K) {
//         int answer = 0;
//         PriorityQueue<Integer> queue = new PriorityQueue<>();
//         for(int i : scoville){
//             queue.add(i);
//         }
        
        
//         while(queue.peek() < K && queue.size() > 1){
//             queue.add(queue.poll() + queue.poll() * 2);
//             answer++;
//         }
        
//         if(queue.size() == 1){
//             if(queue.peek() < K) return -1;
//         }
        
//         return answer;
//     }
    /*
    소요 시간 : 15분
    풀이 : 우선순위 큐에 넣고 꺼내서 K보다 작으면 음식 섞기
    다 섞었는데 K 이상 음식 못만들면 -1 return
    */
    public int solution(int[] scoville, int K) {
        int result = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int s : scoville){
            queue.add(s);
        }
        while(queue.peek() < K && queue.size() > 1){
            queue.add(queue.poll() + queue.poll() * 2);
            result++;
        }
        if(queue.peek() < K){
            return -1;
        }
        return result;
    }
}
