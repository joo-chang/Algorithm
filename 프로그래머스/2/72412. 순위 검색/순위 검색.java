import java.util.*;
class Solution {
    HashMap<String, List<Integer>> map;
    public int[] solution(String[] info, String[] query) {
        // info, query를 배열에 정리 
        // query를 반복문 돌리고
        // 각각 해당하는 지원자가 있으면 count 증가
        // 완전 탐색
        int[] answer = new int[query.length];
        map = new HashMap<>();
        
        // 지원자 map setting
        for(String in : info){
            String[] infoArr = in.split(" ");
            setMap(infoArr, "", 0);
        }
        for (String key : map.keySet()){
            Collections.sort(map.get(key));
        }
        // query setting
        for(int i = 0; i < query.length; i++){
            query[i] = query[i].replaceAll(" and ", "");
            String[] qArr = query[i].split(" ");
            answer[i] = map.containsKey(qArr[0]) ? binarySearch(qArr) : 0;
        }
        
        return answer;
    }
    
    void setMap(String[] arr, String str, int depth){
        if(depth == 4){
            // 키 존재 여부 확인 후 기본 값 세팅 
            if(!map.containsKey(str)){
                map.put(str, new ArrayList<Integer>());
            }
            // 점수 저장
            map.get(str).add(Integer.parseInt(arr[4]));
            return;
        }
        
        // - 일 경우, string 일 경우 두개 다 체크
        setMap(arr, str + "-", depth + 1);
        setMap(arr, str + arr[depth], depth + 1);
    }
    
    int binarySearch(String[] arr){
        List<Integer> list = new ArrayList<>(); 
        list = map.get(arr[0]);
        // 정렬
        int score = Integer.parseInt(arr[1]);
        // null check
        
        // 이분 탐색 - 합격 점수 이상인 지원자 수
        int start = 0;
        int end = list.size() - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(list.get(mid) >= score){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        
        return list.size() - start;
    }
}