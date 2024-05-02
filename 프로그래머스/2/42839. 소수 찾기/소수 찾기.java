import java.util.*;
class Solution {
    /*
    소요 시간 : 30분
    풀이 : 모든 경우의 수 구하기
    모든 경우의 수 중 가장 큰 값으로 소수 구하기(에라토스테네스의 체)
    */
    
    boolean[] visited;
    boolean[] so;
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        
        // 모든 경우의 수 구하기
        dfs(0, "", numbers);
        
        List<Integer> list = new ArrayList<>(set);
        // 내림차순 정렬
        Collections.sort(list, Collections.reverseOrder());
        // 가장 큰 수로 소수 구하기
        prime(list.get(0));
        
        for(int s : list){
            if(s <= 0) continue;
            if(!so[s]){
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
        so = new boolean[number + 1];
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