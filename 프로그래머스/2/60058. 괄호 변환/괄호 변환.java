import java.util.*;
class Solution {
    // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. 
    // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 
    //    단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다. 
    // 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
    //     3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다. 
    // 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. 
    //     4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
    //     4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
    //     4-3. ')'를 다시 붙입니다. 
    //     4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
    //     4-5. 생성된 문자열을 반환합니다.
    
    // 1. 확인 후 리턴
    // 2. 균형잡힌 괄호 분리
    // 3. 올바른 괄호면 return u + step(v) 재귀
    // 4. 올바른 괄호 아니면 '(' + step(v) + ')' + u의 앞뒤 제거하고 나머지 문자열 괄호 바꿔서 리턴
    
    public String solution(String p) {
        return step(p);
    }
    
    public String step(String p){
        boolean flag = true;
        String u = "";
        String v = "";
        // step 1
        if(p.equals("")) return "";
        
        Stack<Character> stack = new Stack<>();
        Stack<Character> check = new Stack<>();
        stack.push(p.charAt(0));
        if(p.charAt(0) == ')') flag = false;
        check.push(p.charAt(0));
        // step 2
        for(int i = 1; i <= p.length(); i++){
            // 균형잡힌 괄호 뽑기
            if(stack.isEmpty()){
                u = p.substring(0, i);
                v = p.substring(i);
                break;
            }

            if(stack.peek() == p.charAt(i)){
                stack.push(p.charAt(i));
            } else{
                stack.pop();
            }
        }
        for(int i = 0 ; i < u.length(); i++){
            // 올바른 괄호 체크
            if(u.charAt(i) == '('){
                check.push(u.charAt(i));
            }else {
                if(!check.isEmpty()){
                    check.pop();
                } else{
                    flag = false;
                }
            }
        }
        // step 3
        if(flag){
            return u + step(v);
        }else {
        // step 4
            if(u.length() >= 2){
                u = u.substring(1, u.length() - 1); 
                System.out.println(u);
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < u.length(); i++){
                if(u.charAt(i) == '(') sb.append(")");
                else sb.append("(");
            }
            return "(" + step(v) + ")" + sb.toString();
        }
    }
    
}
// ()
// ))((()
// ))(( ()