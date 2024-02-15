import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static int n;
    static int m;
    static ArrayList<int[]> virus;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int max = Integer.MIN_VALUE;
    static int nonSafeDefault = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        virus = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                if (num == 2) {
                    virus.add(new int[]{i, j});
                    nonSafeDefault++;
                } else if (num == 1) {
                    nonSafeDefault++;
                }
            }
        }

        wall(0);

        System.out.println(max);
    }

    private static void wall(int count) {
        if (count == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    wall(count + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int nonSafeAdd = 0;
        virus.forEach(xy -> {
            queue.add(new int[]{xy[0], xy[1]});
        });
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            copy[i] = Arrays.copyOf(arr[i], m);
        }
        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = q[0] + dy[i];
                int nx = q[1] + dx[i];
                if (checked(ny, nx)) continue;
                if (copy[ny][nx] == 0) {
                    copy[ny][nx] = 2;
                    nonSafeAdd += 1;
                    queue.add(new int[]{ny, nx});
                }
            }
        }
        safeZone(nonSafeAdd);
    }

    private static boolean checked(int y, int x) {
        return y < 0 || x < 0 || y > n - 1 || x > m - 1;
    }
    private static void safeZone(int nonSafeAdd){
        int safe = (n * m) - nonSafeDefault - nonSafeAdd;
        max = Math.max(max, safe);
    }
}
//49 - 14 - 3 -