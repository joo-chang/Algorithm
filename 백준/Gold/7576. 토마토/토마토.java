import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int[][] arr;
    static int n, m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int max;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        visited = new boolean[m][n];
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                if (num == 1) {
                    list.add(new int[]{i, j});
                } else if (num == 0) {
                    count++;
                }
            }
        }

        bfs(list);
        if (count != 0) {
            System.out.println("-1");
        } else {
            if (max == 0) {
                System.out.println("0");
            }else {
                System.out.println(max + 1);
            }
        }
    }

    private static void bfs(List<int[]> list) {
        Queue<int[]> queue = new LinkedList<>();
        for (int[] temp : list) {
            queue.add(new int[]{temp[0], temp[1], 0});
            visited[temp[0]][temp[1]] = true;
        }
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = temp[0] + dy[i];
                int nx = temp[1] + dx[i];

                if (check(ny, nx) || visited[ny][nx] || arr[ny][nx] == -1) continue;

                visited[ny][nx] = true;
                count--;
                queue.add(new int[]{ny, nx, temp[2] + 1});
                max = Math.max(max, temp[2]);
            }
        }
    }

    private static boolean check(int y, int x) {
        return y < 0 || x < 0 || y >= m || x >= n;
    }


}
