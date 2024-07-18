import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[][] arr;
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        visited = new boolean[26];
        for (int i = 0; i < r; i++) {
            arr[i] = bf.readLine().toCharArray();
        }
        visited[arr[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(result);
    }

    private static void dfs(int y, int x, int count) {
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (check(ny, nx) || visited[arr[ny][nx] - 'A']) continue;
            visited[arr[ny][nx] - 'A'] = true;
            dfs(ny, nx, count + 1);
            visited[arr[ny][nx] - 'A'] = false;
        }
        result = Math.max(result, count);
    }

    private static boolean check(int ny, int nx) {
        return ny < 0 || nx < 0 || ny >= arr.length || nx >= arr[0].length;
    }
}
