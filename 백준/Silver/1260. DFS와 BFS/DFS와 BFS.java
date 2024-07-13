import java.io.*;  
import java.util.*;  
  
class Main {  
  
    static ArrayList<ArrayList<Integer>> graph;  
    static boolean[] visited;  
    static StringBuilder sb;  
    public static void main(String[] args) throws IOException{  
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));  
        StringTokenizer st = new StringTokenizer(bf.readLine());  
        int n = Integer.parseInt(st.nextToken());  
        int m = Integer.parseInt(st.nextToken());  
        int v = Integer.parseInt(st.nextToken());  
        graph = new ArrayList<>();  
  
  
        for(int i = 0; i <= n; i++){  
            graph.add(new ArrayList<>());  
        }  
  
        for (int i = 0; i < m; i++) {  
            st = new StringTokenizer(bf.readLine());  
            int a = Integer.parseInt(st.nextToken());  
            int b = Integer.parseInt(st.nextToken());  
            // 인접 리스트 세팅
            graph.get(a).add(b);  
            graph.get(b).add(a);  
        }  
        // 정렬
        for(ArrayList<Integer> list : graph){  
            Collections.sort(list);  
        }  
        sb = new StringBuilder();  
        visited = new boolean[n + 1];  
        dfs(v);  
        System.out.println(sb);  
  
        sb = new StringBuilder();  
        visited = new boolean[n + 1];  
        bfs(v);  
        System.out.println(sb);  
    }  
  
    private static void dfs(int v) {  
		// 방문 체크 (방문한 노드 재방문 방지)
        visited[v] = true;  
        sb.append(v).append(" ");  
  
        for (int n : graph.get(v)){  
	        // 해당 노드에 연결된 노드 탐색하면서 방문하지 않은 노드 dfs 수행
            if (!visited[n]) {  
                dfs(n);  
            }  
        }  
    }  
  
    private static void bfs(int v) {  
	    //시작 노드 추가
        Queue<Integer> queue = new LinkedList<>();  
        queue.add(v);  
        visited[v] = true;  
        sb.append(v).append(" ");  
  
        while (!queue.isEmpty()) {  
	        // 큐에 있는 값 꺼내기
            int temp = queue.poll();  
			// 노드와 연결된 노드 탐색
            for(int n : graph.get(temp)){  
	            // 방문하지 않은 노드 큐에 넣고 방문 처리
                if (!visited[n]){  
                    queue.add(n);  
                    visited[n] = true;  
                    sb.append(n).append(" ");  
                }  
            }  
        }  
    }  
  
}