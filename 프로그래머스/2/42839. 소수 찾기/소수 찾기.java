import java.util.*;
class Solution {
    /*
    소요 시간 : 2:20
    풀이 : 모든 경우의 수에 소수 구하기
    에라토스테네스의 체
    */
    
    boolean[] visited;
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        
        dfs(0, "", numbers);
        
        for(int s : set){
            if(s <= 0) continue;
            if(!prime(s)){
                answer++;
            }
        }

        return answer;
    }
    
    void dfs(int depth, String num, String numbers){
        if(depth >= numbers.length()){
            return;
        }
        
        for(int i = 0; i < numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                set.add(Integer.parseInt(num + numbers.charAt(i)));
                dfs(depth+1, num + numbers.charAt(i), numbers);
                visited[i] = false;
            }
        }
    }
    
    boolean prime(int number){
        boolean[] so = new boolean[number + 1];
        so[0] = true;
        so[1] = true;
        for(int i = 2; i < Math.sqrt(number + 1); i++){
            if(so[i]) continue;
            for(int j = 2*i; j < so.length; j+= i){
                so[j] = true;
            }
        }
        return so[number];       
    }
}