import java.util.*;
class Solution {
    /*
    소요 시간 : 60분
    조건 : 초당 길이 1씩 간다.
    초당 트럭은 한 대씩 올라갈 수 있다
    풀이 :

    매 초 시간을 체크하고
    다리에 올라갈 수 있는지 체크
    큐가 존재하면 하나 peek 해서 시작 시간과 거리 체크해서 건넜으면 탈출
    조건에 맞으면 큐에 넣는다.
    큐가 존재하지 않으면 종료
    
    */
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int time = 1;
        int total = truck_weights[0];
        int loc = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{truck_weights[0], time});
        
        while(!queue.isEmpty()){
            int[] temp = queue.peek();
            time++;
            if(loc == truck_weights.length){
                time += bridge_length - 1;
                break;
            }
            // 맨 앞 트럭이 나갈 수 있으면
            if(time - temp[1] >= bridge_length){
                queue.poll();
                total -= temp[0];
            }
            // 다리에 올라갈 수 있으면
            if(weight >= total + truck_weights[loc]){
                queue.add(new int[]{truck_weights[loc], time});
                total += truck_weights[loc];
                loc++;
            }
            
        }
        return time;
    }
}