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
        return min + " " + max;
    }
}