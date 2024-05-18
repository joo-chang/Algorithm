import java.util.*;
class Solution {
    /*
    소요 시간 : 
    풀이 : 코스 길이별로 반복문 수행
    모든 주문을 돌면서 코스 길이보다 클 경우 코스 길이 만큼의 모든 주문 조합을 만드는 탐색 수행 
    - 코스 길이 만큼의 주문이 만들어지면 map에 key : 코스메뉴 , value : 개수 count
    모든 주문을 돌았을 때 가장 많이 주문한 코스 list에 저장
    */ 
    static HashMap<String, Integer> map;
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        ArrayList<String> list = new ArrayList<>();
        
        //문자 정렬
        for(int i = 0; i < orders.length; i++){
            char[] c = orders[i].toCharArray();
            Arrays.sort(c);
            orders[i] = String.valueOf(c);
        }
        
        // 코스 개수별로 집계
        for(int i = 0; i < course.length; i++){
            map = new HashMap<>();
            int max = Integer.MIN_VALUE;
            // 모든 주문을 반복
            for(int j = 0; j < orders.length; j++){
                StringBuilder s = new StringBuilder();
                // 주문 개수가 코스 개수보다 작은 경우는 패스
                if(orders[j].length() >= course[i]){
                    dfs(s, orders[j], 0, 0, course[i]);
                }
            }
            // course 크기별로 map에 저장된 메뉴 중 가장 많은 개수 체크
            for(Map.Entry<String, Integer> m : map.entrySet()) {
                max = Math.max(max, m.getValue());
		    }
            // 2개 이상이고 max와 동일한 애들 list에 저장
            for(Map.Entry<String, Integer> m : map.entrySet()) {
                if (m.getValue() >= 2 && max == m.getValue()){
                    list.add(m.getKey());
                }
		    }
        }
        answer = list.toArray(String[]::new);
        Arrays.sort(answer);
        return answer;
    }
    
    public void dfs(StringBuilder s, String order, int index, int depth, int length){
        // course 개수가 맞춰지면 map에 저장
        if(depth == length){
            map.put(s.toString(), map.getOrDefault(s.toString(), 0) + 1);
            return;
        }
        
        for(int i = index; i < order.length(); i++){
            // ABC ABF ABG
            // ACF ACG
            // AFG
            // B...
            s.append(order.charAt(i));
            dfs(s, order, i + 1, depth + 1, length);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
