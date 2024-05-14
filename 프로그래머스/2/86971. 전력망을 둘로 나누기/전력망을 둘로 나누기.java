import java.util.*;
class Solution {
    /*
    소요 시간 : 24/5/14 60분
    풀이 : 인접 리스트 형태로 그래프 초기화
    wire를 하나씩 제거하면서 bfs를 수행하고 최솟값 찾기
    */
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 구성
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            graph.get(a).remove((Integer)b);
            graph.get(b).remove((Integer)a);
            
            boolean[] visited = new boolean[n+1];
            
            // a에 연결된 개수
            int size = bfs(a, graph, visited);
            
            int gap = Math.abs(size - (n - size));
            // 최소값 찾기
            answer = Math.min(answer, gap);
            
            // 끊었던 wire 다시 연결
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        return answer;
    }
    
    int bfs(int a, List<List<Integer>> graph, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        visited[a] = true;
        int count = 1;
        queue.add(a);
        
        // 연결된 노드 개수 체크
        while(!queue.isEmpty()){
            int num = queue.poll();
            for(int node : graph.get(num)){
                if(!visited[node]){
                    visited[node] = true;
                    queue.add(node);
                    count++;
                }
            }
        }
        return count;
    }
}