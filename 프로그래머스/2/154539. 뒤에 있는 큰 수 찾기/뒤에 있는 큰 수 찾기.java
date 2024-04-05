import java.util.*;
class Solution {
    /**
    소요 시간 : 
    접근 방법 : 배열 길이가 100만이기 때문에 하나씩 확인하는 방법은 최악의 경우 n제곱이 될 수 있다.
    stack을 이용해서 하나씩 넣고, 해당 값이 스택에 들어가있는 값보다 큰지 확인.
    크면 꺼내서 해당 위치에 값 넣기.
    */
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        for(int i = 1; i < numbers.length; i++){
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                    answer[stack.pop()] = numbers[i];
            }
            stack.add(i);
        }
        while(!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }

        return answer;
    }
}