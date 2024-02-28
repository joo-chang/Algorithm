import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static ArrayList<Integer>[] lists;
    static boolean[] visited;
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        lists = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i = 0 ; i < n + 1; i++){
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            //양방향 노드 세팅
            lists[a].add(b);
            lists[b].add(a);
        }
        for (int i = 0; i < lists.length; i++) {
            Collections.sort(lists[i]);
        }

        dfs(v);
        System.out.println();
        ////// BFS
        // 방문 배열 초기화
        visited = new boolean[n+1];
        queue = new LinkedList<>();
        bfs(v);
    }

    // 3부터 시작
    // 3 true 3이랑 연결 노드 도는데 1들어가고 2들어가. true로 만들어.3 1 2 5
    static void dfs(int s){
        if(visited[s]) return;
        visited[s] = true;
        System.out.print(s+" ");
        for (int i : lists[s]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int s) {
        queue.add(s);
        visited[s] = true;
        System.out.print(s + " ");
        for (int i = 0; i < lists.length; i++) {
            if(!queue.isEmpty()){
                int pop = queue.poll();
                for (int node : lists[pop]) {
                    if (visited[node]) continue;
                    System.out.print(node + " ");
                    queue.add(node);
                    visited[node] = true;
                }
            }else return;
        }
    }
}
