import java.util.Stack;
class Solution {
    public int solution(String s) {
        int answer = 0;
        // stack에 괄호 시작을 다 넣고 닫는 괄호가 나왔을 때, 하나 꺼내봐서 짝맞으면 count 증가
        // 닫는 괄호 만났는데 괄호가 안맞거나, 스택이 비어있을 때 continue;
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        String tag ="";
        // s 크기만큼 왼쪽 이동
        for(int i = 0; i < s.length(); i++){
	        stack = new Stack<>();
	        for(int j = 0; j < s.length(); j++){
		        if(s.charAt(j) == '{' || s.charAt(j) == '(' || s.charAt(j) == '['){
			        stack.push(s.charAt(j));
			        continue;
		        }else{
			        if(stack.isEmpty()){
				        flag = false;
				        break;
				    }else{
						switch(stack.pop()){
					        case '{':
						        if(s.charAt(j) == '}') continue;
						        else{
							        flag = false;
							        break;
						        }
					        case '(':
					        	if(s.charAt(j) == ')') continue;
						        else{
							        flag = false;
							        break;
						        }
					        case '[':
						        if(s.charAt(j) == ']') continue;
						        else{
							        flag = false;
							        break;
						        }
				        }
				    }
		        }
	        }
            if(!stack.isEmpty()) flag = false;
			if (flag) answer++;
			flag = true;
	        
	        //이동
	        tag = String.valueOf(s.charAt(0));
	        s = s.substring(1).concat(tag);
        }
        
        return answer;
    }
}