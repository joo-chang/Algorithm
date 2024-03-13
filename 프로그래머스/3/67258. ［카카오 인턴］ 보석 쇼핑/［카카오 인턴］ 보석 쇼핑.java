import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        // 진열된 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간 구매
        // 배열 100,000 / 0부터 시작이므로 result는 +1
        // 최소값을 확인하려면 최소 한번은 다 돌아야 됨
        
        // 각각 개수를 먼저 체크하고, 찾아야할 종류 개수 체크
        // start, end 값 세팅 후 end 값을 조정하면서 포함된 값 개수 체크
        // 첫번째 값이랑 들어갈 값이랑 비교해서 같으면 - start+1, end+1
        // 모든 종류의 보석이 들어갈 때까지 반복하고 다 들어갔으면 맨앞 값이 들어가있는 개수 체크해서 2개 이상이면 - start+1
        // 일단 기본 완성
        
        // 고려해야할 것 최소 개수 : 현재 위치 잼이 마지막 잼일 경우까지는 최소값 체크해봐야 된다.
        int[] answer = new int[2];
        int findSize = new HashSet<>(Arrays.asList(gems)).size();
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        
        // 구간에 들어가있는 개수 체크 용도
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String gem : gems){
            // 하나 추가
            map.put(gem, map.getOrDefault(gem, 0) + 1);
            // 맨앞 값이 들어가있는 개수 체크해서 2개 이상이면 start+1
            while(map.get(gems[start]) > 1){
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }
            if(map.size() == findSize && min > end - start){
                min = end - start;
                answer[0] = start + 1;
                answer[1] = end + 1;
            }
            end++;
        }
        
        return answer;
    }
}