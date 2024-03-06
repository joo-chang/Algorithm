class Solution {
    int[] answer;
    int[][] users;
    int[] emoticons;
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        // 할인율을 각각 적용해서 어떤 할인율이 이모티콘 플러스 가입 최대 인지,판매액 최대인지 확인
        // 완전 탐색
        // 할인율 10부터 40까지 dfs 수행하면 될듯
        this.users = users;
        this.emoticons = emoticons;
        for(int i = 10; i <= 40; i+=10){
            int[] arr = new int[emoticons.length];
            dfs(0, arr);
        }
        return answer;
    }

    public void dfs(int depth, int[] arr){
        if (depth == emoticons.length){
            int plus = 0;
            int cost = 0;

            for (int[] user: users){

                int sum = 0;

                for (int i = 0; i < emoticons.length; i++){
                    if (arr[i] >= user[0]){
                        sum += emoticons[i] * (100 - arr[i]) / 100;
                    }
                }
                if (sum >= user[1]) plus++;
                else cost += sum;
            }
            if (plus > answer[0]){
                answer[0] = plus;
                answer[1] = cost;
            }else if (plus == answer[0]){
                answer[1] = Math.max(answer[1], cost);
            }
            return;
        }

        for(int i = 10; i <= 40; i += 10){
            arr[depth] = i;
            dfs(depth + 1, arr);
        }
    }
}