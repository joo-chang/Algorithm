import java.util.Arrays;
class Solution {
    public String solution(String s) {
        String[] split = s.split(" ");
        int n = Integer.parseInt(split[0]);
        int max = n;
        int min = n;
        
        for (int i = 1; i < split.length; i++) {
            n = Integer.parseInt(split[i]);
            max = max < n ? n : max;
            min = min > n ? n : min;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        return sb.toString();
    }
}