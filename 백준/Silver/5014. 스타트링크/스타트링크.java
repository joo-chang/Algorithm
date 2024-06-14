import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] visited = new int[F+1];

        bfs(F, S, G, U, D, visited);

        if(visited[G] == 0) {
            System.out.println("use the stairs");
            return;
        }
        System.out.println(visited[G] - 1);
    }

    private static void bfs(int f, int s, int g, int u, int d, int[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = 1;

        while(!q.isEmpty()){
            int x = q.poll();
            if(x == g) return;

            if(x + u <= f && visited[x + u] == 0) {
                q.add(x + u);
                visited[x + u] = visited[x] + 1;
            }
            if (x - d > 0 && visited[x - d] == 0) {
                q.add(x - d);
                visited[x - d] = visited[x] + 1;
            }
        }
    }

}