import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    num = -1;
                } else if (num == 2) {
                    y = i;
                    x = j;
                    num = 0;
                }
                arr[i][j] = num;
            }
        }
        bfs(y, x);
        StringBuilder sb = new StringBuilder();
        for (int[] ints : arr) {
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

        private static void bfs(int y, int x) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{y, x});
            while (!queue.isEmpty()) {
                int[] t = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = t[0] + dy[i];
                    int nx = t[1] + dx[i];
                    if (check(ny, nx) || arr[ny][nx] != -1) continue;

                    queue.add(new int[]{ny, nx});
                    arr[ny][nx] = arr[t[0]][t[1]] + 1;
                }
            }
        }

    private static boolean check(int ny, int nx) {
        return ny < 0 || nx < 0 || ny >= arr.length || nx >= arr[0].length;
    }

}
