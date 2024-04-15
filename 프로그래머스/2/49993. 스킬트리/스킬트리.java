import java.util.*;
class Solution {
    /*
    소요 시간 : 35분
    풀이 : skill을 큐에 넣고 스킬트리 하나씩 비교하면서 배우려는 스킬이 큐에 존재하는데, 큐 맨앞에 배워야할 스킬이 존재한다면 불가능
    큐에 없으면 패스, 맨 앞 값이랑 동일하면 pop()
    */
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i = 0; i < skill_trees.length; i++){
            Queue<Character> queue = new LinkedList<>();
            boolean flag = true;
            for(int j = 0; j < skill.length(); j++){
                queue.add(skill.charAt(j));
            }
            
            for(int k = 0; k < skill_trees[i].length(); k++){
                char c = skill_trees[i].charAt(k);
                if(queue.contains(c)){
                    if(queue.peek() == c){
                        queue.poll();
                    }else {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag){
                answer++;
            }

        }
        return answer;
    }
}