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
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
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
        visited[v] = true;
        sb.append(v).append(" ");

        for (int n : graph.get(v)){
            if (!visited[n]) {
                dfs(n);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        sb.append(v).append(" ");

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for(int n : graph.get(temp)){
                if (!visited[n]){
                    queue.add(n);
                    visited[n] = true;
                    sb.append(n).append(" ");
                }
            }
        }
    }

}
