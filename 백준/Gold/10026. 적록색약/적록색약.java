import java.io.*;

class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static boolean[][] rgVisited;
    static char[][] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        arr = new char[n][n];
        visited = new boolean[n][n];
        int count = 0;
        int rgcount = 0;
        for (int i = 0; i < n; i++) {
            String line = bf.readLine();
            arr[i] = line.toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, arr[i][j]);
                    count++;
                }
            }
        }
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, arr[i][j]);
                    rgcount++;
                }
            }
        }
        System.out.println(count + " " + rgcount);
    }


    private static void dfs(int y, int x, char c) {
        visited[y][x] = true;
        if (arr[y][x] == 'G'){
            arr[y][x] = 'R';
        }

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (check(ny, nx) || visited[ny][nx] || arr[ny][nx] != c) continue;
            dfs(ny, nx, c);
        }
    }

    private static boolean check(int ny, int nx) {
        return visited.length <= ny || ny < 0 || visited[0].length <= nx ||  nx < 0;
    }
}


