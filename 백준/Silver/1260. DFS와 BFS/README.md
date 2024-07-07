# [Silver II] DFS와 BFS - 1260 

[문제 링크](https://www.acmicpc.net/problem/1260) 

### 성능 요약

메모리: 17432 KB, 시간: 188 ms

### 분류

그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색

### 제출 일자

2024년 7월 6일 09:51:47

### 문제 설명

<p>그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.</p>

### 입력 

 <p>첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.</p>

### 출력 

 <p>첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.</p>

---

## 풀이



```java
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
```