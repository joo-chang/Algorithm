class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        // list에 다 넣는데, 각각 out, in 개수를 측정
        // out 2개 이상, in 0 이면 정점
        // out 1개, in 1개면 도넛인데 1,1은 많으니까 예외
        // out 0개 막대
        // out 2개, in > 0 8자
        
        // 정점 out 개수 = 그래프 개수
        // 각각 조건에 맞는 그래프 개수 찾고, 정점 out 개수에서 빼주면 도넛 그래프 수가 나옴
        
        int[][] edgeCnt = new int[edges.length + 2][2];
        for(int i = 0 ; i < edges.length; i++){
            edgeCnt[edges[i][0]][0] += 1;
            edgeCnt[edges[i][1]][1] += 1;
        }
        int top = 0;
        int stick = 0;
        int eight = 0;
        for(int i = 1; i < edgeCnt.length; i++){
            if(edgeCnt[i][0] == 0 && edgeCnt[i][1] == 0) continue;
            else if (edgeCnt[i][0] == 0) stick += 1;
            else if (edgeCnt[i][0] >= 2 && edgeCnt[i][1] == 0) top = i;
            else if (edgeCnt[i][0] == 2 && edgeCnt[i][1] > 0) eight += 1;
        }
        answer[0] = top;
        answer[1] = edgeCnt[top][0] - stick - eight;
        answer[2] = stick;
        answer[3] = eight;
        
        return answer;
    }
}