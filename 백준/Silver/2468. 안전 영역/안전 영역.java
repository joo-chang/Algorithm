import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr;
    static boolean[][] visited;
    static int result = 0;
    static int max = 0;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int count = 0;
        StringTokenizer st;
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
                min = Math.min(min, arr[i][j]);
            }
        }

        for (int i = min; i < max; i++) {
            visited = new boolean[n][n];
            count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!visited[j][k] && arr[j][k] > i) {
                        count++;
                        bfs(j, k, i);
                    }
                }
            }
            result = Math.max(result, count);
        }
        if (result == 0) {
            System.out.println("1");
            return;
        }
        System.out.println(result);
    }

    private static void bfs(int y, int x, int depth) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] t = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + t[0];
                int nx = dx[i] + t[1];
                if (check(ny, nx) || visited[ny][nx] || depth >= arr[ny][nx]) continue;
                queue.add(new int[]{ny, nx});
                visited[ny][nx] = true;
            }
        }
    }

    private static boolean check(int ny, int nx) {
        return ny < 0 || nx < 0 || ny >= arr.length || nx >= arr[0].length;
    }
}