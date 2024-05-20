class Solution {
    /*
    소요 시간 : 10분
    풀이 : 10으로 나눈 나머지가 5보다 크면 result += 10 - 나머지 // 10으로 나눈 몫에 + 1
    작으면 result += 나머지
    반복
    ex) 2554 = 255   4
        255 = 25     9
        25 = 2       14
        2 = 0        16
    */
    public int solution(int storey) {
        int answer = 0;
        int remain = 0;
        
        while(storey != 0){
            remain = storey % 10;
            storey /= 10;

            if(remain < 6){
                answer += remain;
                if(remain == 5 && storey % 10 >= 5){
                    storey++;
                }
            }else{
                answer += 10 - remain;
                storey++;
            }
        }
        return answer;
    }
}