import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    // 가중치 없는 방향 그래프 G가 주어졌을때 모든 정점 (i, j)에 대해서, i에서 j로 가는 길이가 양수인 경로가 있는지 없는지
    // 그래프를 만들어서 bfs 수행하는데, 갈 수 있는 모든 경로 방문 배열 체크

    // 1,2  2,3   3,1
    // 1,4  2,7  4,5  4,6  5,1  6,7  7,3
    // 1 - 4
    // 2 - 7
    // 4 - 5, 6
    // 5 - 1
    // 6 - 7
    // 7 - 3

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[][] visited;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        visited = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    visited[i][j] = 1;
                    graph.get(i).add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            bfs(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(visited[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        boolean[] check = new boolean[n];
        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (Integer i : graph.get(num)) {
                if (!check[i]) {
                    check[i] = true;
                    visited[x][i] = 1;
                    queue.add(i);
                }
            }
        }
    }

}