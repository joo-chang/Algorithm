import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[][] arr;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0, arr[0][0]));
    }

    private static int dfs(int y, int x, int num) {
        if (y == arr.length - 1 && x == arr[0].length - 1) {
            return 1;
        }
        if (visited[y][x] == -1) {
            visited[y][x] = 0;
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (check(ny, nx)) continue;
                if (arr[ny][nx] < num) {
                    visited[y][x] += dfs(ny, nx, arr[ny][nx]);
                }
            }
        }
        return visited[y][x];
    }

    private static boolean check(int ny, int nx) {
        return ny < 0 || nx < 0 || ny >= arr.length|| nx >= arr[0].length;
    }
}
