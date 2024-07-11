import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Main {

    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static ArrayList<Integer> result;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];
        result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = bf.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && arr[i][j] == 1){
                    bfs(i, j);
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        result.forEach(System.out::println);
    }

    private static void bfs(int y, int x) {
        visited[y][x] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        int count = 1;
        while (!queue.isEmpty()) {
            int[] area = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = area[0] + dy[i];
                int nx = area[1] + dx[i];
                if (!check(ny, nx) && !visited[ny][nx] && arr[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    queue.add(new int[]{ny, nx});
                    count++;
                }
            }
        }
        result.add(count);
    }

    private static boolean check(int ny, int nx) {
        return ny < 0 || nx < 0 || ny >= arr.length || nx >= arr[0].length;
    }
}
