import java.util.*;
class Solution{
    static char[] priority = {'*', '+', '-'};
    static long max = Integer.MIN_VALUE;
    public long solution(String expression) {
        long answer = 0;
        // 연산자 우선순위
        // 음수면 절대값 반환
        // 연산자 우선순위를 바꾸면서 재귀로 연산된 배열 넘기기?
        // 마지막 연산에 최대값 비교
        ArrayList<Long> num = new ArrayList<>();
        ArrayList<String> oper = new ArrayList<>();
        String number = "";
        for(int i = 0; i < expression.length(); i++){
            if(Character.isDigit(expression.charAt(i))){
                number += expression.charAt(i);
                if (i == expression.length() - 1) {
                    num.add(Long.parseLong(number));
                }
            }else{
                num.add(Long.parseLong(number));
                oper.add(String.valueOf(expression.charAt(i)));
                number = "";
            }
        }
        
        dfs(num, oper, 0);
        
        return max;
    }
    
    public void dfs(ArrayList<Long> num, ArrayList<String> oper, int depth){
        if(depth == 2){
            max = Math.max(max, Math.abs(calc(num, oper)));
            return;
        }
        
        for(int i = depth; i < priority.length; i++){
            swap(i, depth);
            dfs(num, oper, depth + 1);
            swap(depth, i);
        }
    }
    
    public void swap(int i, int j){
        char temp = priority[i];
        priority[i] = priority[j];
        priority[j] = temp;
    }
    
    public long calc(ArrayList<Long> num, ArrayList<String> oper){
        ArrayList<Long> numCopy = (ArrayList<Long>) num.clone();
        ArrayList<String> operCopy = (ArrayList<String>) oper.clone();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < operCopy.size(); j++) {
                if (operCopy.get(j).equals(String.valueOf(priority[i]))) {
                    switch (operCopy.get(j)) {
                        case "*":
                            numCopy.add(j, numCopy.remove(j) * numCopy.remove(j));
                            break;
                        case "+":
                            numCopy.add(j, numCopy.remove(j) + numCopy.remove(j));
                            break;
                        case "-":
                            numCopy.add(j, numCopy.remove(j) - numCopy.remove(j));
                            break;
                    }
                    operCopy.remove(j--);
                }
            }
        }
        return numCopy.get(0);
    }
}