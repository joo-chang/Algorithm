class Solution {
    int max = Integer.MIN_VALUE;
    int[] answer;
    public int[] solution(int n, int[] info) {
        answer = new int[11];

        // 점수 높은 순서로 다 점수 매기고
        // 어피치가 1개 이상일 경우 작은 점수 부터 빼서 어피치가 못맞춘 과녁에 맞추기\
        int[] lion = new int[11];
        dfs(info, n, 0, lion);
        if(max == Integer.MIN_VALUE){
            return new int[]{-1};
        }
        return answer;
    }
    void dfs(int[] info, int n, int depth, int[] lion){
        if(depth == n){
            int apeachPoint = 0;
            int lionPoint = 0;

            for(int i = 0 ; i < 11; i++){
                if(info[i] != 0 || lion[i] != 0){
                    if(info[i] < lion[i]){
                        lionPoint += 10 - i;
                    }else{
                        apeachPoint += 10 - i;
                    }
                }
            }
            if(apeachPoint < lionPoint && max <= lionPoint - apeachPoint){
                max = lionPoint - apeachPoint;
                answer = lion.clone();
            }
            return;
        }

        for(int i = 0; i < 11 && lion[i] <= info[i]; i++){
            lion[i]++;
            dfs(info, n, depth+1, lion);
            lion[i]--;
        }
    }
}