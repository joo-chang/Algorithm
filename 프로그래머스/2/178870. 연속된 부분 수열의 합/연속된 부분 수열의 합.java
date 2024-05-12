class Solution {
    /*
    소요 시간 : 24/5/12 55분
    풀이 : 
    1. 좌표 s, e 설정 
    2. sum이 k보다 작으면 e를 증가하고 크면 s를 증가
    3. sum == k 인데 e-s 값이 min보다 작으면(같으면 x) min, s, e 갱신
    */
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int s = 0;
        int e = 0;
        int min = Integer.MAX_VALUE;
        int sum = sequence[0];
        int n = sequence.length - 1;
        
        while(true){
            if(sum == k){
                if(e - s < min){
                    min = e-s;
                    answer[0] = s;
                    answer[1] = e;
                }
            }
            if(s == n && e == n) break;
            if(sum <= k && e < n){
                e++;
                if(s < n) sum += sequence[e];
            }else{
                if(s < n) sum -= sequence[s];
                s++;
            }
        }
        return answer;
    }
}