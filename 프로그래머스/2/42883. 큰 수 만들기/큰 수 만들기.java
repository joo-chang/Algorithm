class Solution {
    /*
    소요 시간 : 120분
    풀이 :
    k개를 제외한 횟수만큼 반복문을 수행한다. 한 번 수행할 때마다 결과 숫자가 쌓임
    이중포문에서는 현재 위치부터 k개 만큼 반복문을 수행해서 최대값을 저장한다.
    최대값 저장 시 최대값 다음 위치를 idx로 설정한다.
    */
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int max = 0;
        for(int i = 0; i < number.length() - k; i++){
            max = 0;
            for(int j = idx; j <= i + k; j++){
                if(max < number.charAt(j) - '0'){
                    max = number.charAt(j) - '0';
                    idx = j+1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}