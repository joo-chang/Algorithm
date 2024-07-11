class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int[] left = new int[10001], right = new int[10001];
        int ls = 0, rs = 0;
        // 오른쪽에 모든 값 세팅
        for(var i : topping) right[i]++;
        // 토핑 종류
        for(var i : right) rs += i > 0 ? 1 : 0;
        // 오른쪽 개수 줄이면서 왼쪽 개수 증가
        // 0일 경우 왼쪽 토핑 증가
        for(var i : topping) {
            right[i]--;
            if (right[i] == 0) rs--;
            if (left[i] == 0) ls++;
            left[i]++;
            if (rs == ls) answer++;
        }
        return answer;
    }
}
