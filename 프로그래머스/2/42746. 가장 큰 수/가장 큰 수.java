import java.util.*;
class Solution {
    /*
    소요 시간 : 30분
    풀이 : 역순으로 정렬하는데 2자리 이상인 것들은 10으로 나눈 몫을 체크해서 정렬
    */ 
    public String solution(int[] numbers) {
        String answer = "";
        String[] nums = Arrays.stream(numbers).mapToObj(x -> String.valueOf(x)).toArray(String[]::new);
        Arrays.sort(nums, (o1,o2) -> {
            return (o2 + o1).compareTo(o1 + o2);
        });
        StringBuffer sb = new StringBuffer();
        if(nums[0].equals("0")) return "0";
        Arrays.stream(nums).forEach(x -> sb.append(x));
        return sb.toString();
    }
}