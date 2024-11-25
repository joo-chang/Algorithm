import java.io.*;
import java.util.StringTokenizer;

class Main {

    static int[][] arr;
    static int n, m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = { 1, 0, -1, 0};
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, arr[i][j], 1);
                visited[i][j] = false;
                t(i, j);
            }
        }
        System.out.println(max);
    }

    private static void t(int y, int x) {
        if (y + 2 < n && x + 1 < m) {
            max = Math.max(max, arr[y][x] + arr[y + 1][x] + arr[y + 1][x + 1] + arr[y + 2][x]);
        }
        if (y + 2 < n && x - 1 >= 0) {
            max = Math.max(max, arr[y][x] + arr[y + 1][x] + arr[y + 1][x - 1] + arr[y + 2][x]);
        }
        if (y + 1 < n && x + 2 < m) {
            max = Math.max(max, arr[y][x] + arr[y][x + 1] + arr[y + 1][x + 1] + arr[y][x + 2]);
        }
        if(y - 1 >= 0 && x + 2 < m) {
            max = Math.max(max, arr[y][x] + arr[y][x + 1] + arr[y - 1][x + 1] + arr[y][x + 2]);
        }
    }

    private static void dfs(int y, int x, int sum, int depth) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (check(ny, nx) || visited[ny][nx]) continue;

            visited[ny][nx] = true;
            dfs(ny, nx, arr[ny][nx] + sum, depth+1);
            visited[ny][nx] = false;
        }
    }

    private static boolean check(int ny, int nx) {
        return ny >= n || ny < 0 || nx >= m || nx < 0;
    }


}


