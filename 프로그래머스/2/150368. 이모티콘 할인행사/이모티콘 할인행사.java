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
            int subscribe = 0;
            int cost = 0;

            for (int[] user: users){
                int userDiscountRate = user[0];
                int userMaxCost = user[1];

                int sum = 0;

                for (int i = 0; i < emoticons.length; i++){
                    if (arr[i]>=userDiscountRate){
                        sum += emoticons[i]/100*(100-arr[i]);
                    }
                }
                if (sum>=userMaxCost)subscribe++;
                else cost+=sum;
            }
            if (subscribe>answer[0]){
                answer[0] = subscribe;
                answer[1] = cost;
            }else if (subscribe == answer[0]){
                answer[1] = Math.max(answer[1], cost);
            }
            return;
        }

        for(int i = 10; i <= 40; i += 10){
            arr[depth] = i;
            dfs(depth + 1, arr);
        }
    }
    public int totalCheck(int[] total){
        int sum = 0;
        for(int t : total){
            sum += t;
        }
        return sum;
    }
}