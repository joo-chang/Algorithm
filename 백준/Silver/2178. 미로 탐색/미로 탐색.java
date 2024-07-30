import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int[][] arr;
    static int n, m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String num = bf.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = num.charAt(j) - '0';
            }
        }

        bfs(0,0);

        System.out.println(arr[n - 1][m - 1]);
    }

    private static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = temp[0] + dy[i];
                int nx = temp[1] + dx[i];

                if (check(ny, nx) || arr[ny][nx] != 1) continue;

                arr[ny][nx] = arr[temp[0]][temp[1]] + 1;
                queue.add(new int[]{ny, nx});
                if (ny == n && nx == m) break;
            }
        }

    }

    private static boolean check(int y, int x) {
        return y < 0 || x < 0 || y >= n || x >= m;
    }


}
