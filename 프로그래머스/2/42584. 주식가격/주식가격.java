import java.util.*;
class Solution {
    /*
    소요 시간 : 45분
    메모 : 입력 값이 10만이라 이중 반복문은 안되고 Map에 list로 담아서 작은 값 계산?
          질문하기 참고했음.
    
    풀이 : 스택에 쌓다가 스택 마지막 값보다 작으면 위치 값이랑 시간 계산, 값이 클 때까지 반복
          모든 주식 한 바퀴 돌면 스택에 남아있는 값들 (총길이 - 1) - 위치해서 저장해주기
    */
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i < prices.length; i++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int s = stack.pop();
                answer[s] = i - s;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int s = stack.pop();
            answer[s] = prices.length - 1 - s;
        }
        return answer;
    }
}