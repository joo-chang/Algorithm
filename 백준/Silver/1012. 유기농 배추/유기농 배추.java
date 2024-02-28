import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int answer = 0;
            arr = new int[n][m];
            visited = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                arr[y][x] = 1;
            }
            for (int j = 0; j < m; j++) {
                for (int l = 0; l < n; l++) {
                    if (arr[l][j] == 1 && !visited[l][j]) {
                        dfs(l, j);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }

    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;

            if (check(ny, nx) || arr[ny][nx] == 0) continue;

            if (!visited[ny][nx]) {
                dfs(ny, nx);
            }
        }
    }

    private static boolean check(int y, int x) {
        return y < 0 || x < 0 || y >= arr.length || x >= arr[0].length;
    }

}
