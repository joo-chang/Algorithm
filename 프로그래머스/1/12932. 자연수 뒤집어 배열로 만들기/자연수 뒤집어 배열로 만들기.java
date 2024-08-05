class Solution {
    public int[] solution(long n) {
        String nl = Long.toString(n);
        int[] answer = new int[nl.length()];
        int idx = 0;
        while (n > 0) {
            answer[idx++] = (int)(n % 10);
            n /= 10;
        }
        return answer;
    }
}