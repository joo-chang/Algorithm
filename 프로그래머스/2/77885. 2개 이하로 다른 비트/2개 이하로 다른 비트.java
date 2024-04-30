class Solution {
    /*
    소요 시간 : 50분
    풀이 : 
    짝수일 때 - 1의 자리 수가 0이므로 +1만 해주면 된다.
    홀수일 때 - 2로 나눠가면서 0이 나오는 위치를 1로 바꿔주고 그 전 위치 값을 0으로 바꿔준다. (가장 작은 변동)
    ex) 1011(11) + 100(4) - 10 (2) = 1101(13)
    */
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] % 2 == 0){
                answer[i] = numbers[i] + 1;
                continue;
            }
            long num = numbers[i];
            int n = 0;
            while(true){
                if(num % 2 == 0){
                    answer[i] = numbers[i] + (long)Math.pow(2, n) - (long)Math.pow(2, n - 1);
                    break;
                }
                num /= 2;
                n++;
            }
        }
        return answer;
    }
}