import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static List<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static int bacon = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 1; i <= n; i++) {
            bfs(i);
        }
        System.out.println(bacon);
    }

    private static void bfs(int i) {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[graph.size()];
        q.add(new int[]{i, 0});
        visited[i] = true;
        int count = 0;
        while (!q.isEmpty()) {
            int[] x = q.poll();
            for (int num : graph.get(x[0])) {
                if (!visited[num]) {
                    q.add(new int[]{num, x[1] + 1});
                    visited[num] = true;
                    count += x[1] + 1;
                }
            }
        }
        if (count < min) {
            min = count;
            bacon = i;
        }
    }
}