import java.util.*;
class Solution {
    /*
    소요 시간 : 20분
    풀이 : 컨테이너 벨트 - 큐
    보조 컨테이너 벨트 - 스택
    큐와 스택을 확인해가면서 둘다 해당 값이 아닐 때까지 반복
    어차피 큐는 1부터 커지니까 현재 위치만 체크하면 될 듯하다.
    
    */
    public int solution(int[] order) {
        int answer = 0;
        int loc = 1;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < order.length; i++){
            // order가 같을 때까지 stack에 넣는다.
            while(order[i] > loc){
                stack.add(loc);
                loc++;
            }
            // order가 같으면 answer 증가
            if(loc == order[i]){
                answer++;
                loc++;
            }else{
                // 다르면 스택에 있는 값 확인해서 같은지 확인, 다르면 둘다 택배 싣지 못하니까 탈출
                if(!stack.isEmpty() && stack.peek() == order[i]){
                    stack.pop();
                    answer++;
                }else{
                    break;
                }
            }
        }
        
        return answer;
    }
}