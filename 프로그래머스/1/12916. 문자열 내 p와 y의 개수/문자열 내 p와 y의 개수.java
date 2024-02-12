class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        // int p = s.chars().filter(c -> c == 'p').count();
        // int y = s.chars().filter(c -> c == 'y').count();
        return s.chars().filter(c -> c == 'y').count() == s.chars().filter(c -> c == 'p').count() ? true : false;
    }
}