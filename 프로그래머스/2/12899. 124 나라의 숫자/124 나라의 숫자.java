class Solution {
    /*
    소요 시간 : 
    풀이 : 3진수 만들기 3으로 나눈 나머지
    나머지가 0이면 하나 작은 값에 4
    */
    public String solution(int n) {
        String answer = "";
        int remainder = 0;
	
        while (n != 0) {
            remainder = n % 3;
            n = n / 3;

            if (remainder == 0) { //나누어 떨어질 경우 몫을 1빼준다.
                answer = "4" + answer;
                n--;
            }
            else if (remainder == 1) {
                answer = "1" + answer;
            }
            else if (remainder == 2) {
                answer = "2" + answer;
            }
        }
        return answer;
    }
}
// 1 2 
// 10 11 12
// 20 21 22
// 100 101 102
// 110 111 112
// 120 121 122
// 201 