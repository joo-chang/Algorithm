import java.io.*;
import java.util.StringTokenizer;

class Main {

    private static int n, m;
    private static char[][] arr;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static boolean[][] visited;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int x = 0, y = 0;
        arr = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            char[] c = bf.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = c[j];
                if (arr[i][j] == 'I') {
                    y = i;
                    x = j;
                }
            }
        }
        dfs(y, x);

        if (cnt == 0) {
            System.out.println("TT");
        } else {
            System.out.println(cnt);
        }
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;
        if (arr[y][x] == 'P') {
            cnt++;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (check(ny, nx) || arr[ny][nx] == 'X' ) continue;
            if (!visited[ny][nx]) {
                dfs(ny, nx);
            }
        }
    }

    private static boolean check(int y, int x) {
        return x < 0 || y < 0 || x >= m || y >= n;
    }
}


