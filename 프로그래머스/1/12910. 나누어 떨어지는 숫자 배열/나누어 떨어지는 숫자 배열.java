import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer;
        List<Integer> list = new ArrayList<>();
        for(int ar : arr){
            if(ar % divisor == 0){
                list.add(ar);
            }
        }
        if(list.size() == 0) return new int[]{-1};
        Collections.sort(list);
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}