class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];

        for(int i = 0; i < arr.length - 1; i++){
            for(int j = arr[i+1]; j > 0; j-- ){
                if(answer % j == 0 && arr[i+1] % j == 0){
                    answer = answer * arr[i+1] / j;
                    break;
                }
            }
        }
        return answer;
    }
}