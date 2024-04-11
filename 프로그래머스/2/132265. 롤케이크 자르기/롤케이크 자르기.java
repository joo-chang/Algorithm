import java.util.*;
class Solution {
    /*
    소요 시간 : 30분
    도움 여부 : 
    풀이 : 토핑 종류를 체크해서 홀수개면 0 리턴. 짝수개면 토핑 종류가 절반이되는 수 체크
          토핑 종류에 상관없이 중복이 있을 수 있으므로 의미 없음
          
          종류와 개수를 체크하고 동생이 한개씩 가져올 때마다 종류와 개수 체크해서 같으면 증가
    */
    public int solution(int[] topping) {
        int answer = 0;
        int kind = (int)Arrays.stream(topping).distinct().count();
        Set<Integer> bro = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int t : topping){
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        for(int t : topping){
            int get = map.get(t);
            if(get != 0){
                bro.add(t);
                map.put(t, get - 1);
                if(get == 1){
                    kind--;
                }
            }
            if(bro.size() == kind){
                answer++;
            }else if(bro.size() > kind){
                break;
            }
        }
        return answer;
    }
}