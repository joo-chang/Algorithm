import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int answer = 0;
    static int count = 0;
    static int temp = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int search = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        boolean[][] visited;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0) {
                    count++;
                }
            }
        }

        while(true){
            visited = new boolean[n][m];
            search = 0;
            temp = 0;
            boolean flag = false;
            loop:
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j] != 0){
                        flag = true;
                        dfs(arr, visited, i, j, 1);
                        break loop;
                    }
                }
            }
            if(!flag) break;

            if(search < count){
                System.out.println(answer);
                return;
            }
            count -= temp;
            answer++;
            if (count == 0) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int[][] arr, boolean[][] visited, int y, int x, int depth) {
        search++;
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= arr[0].length || ny >= arr.length) continue;
            if(arr[ny][nx] == 0 && !visited[ny][nx]){
                if(arr[y][x] == 1){
                    arr[y][x] = 0;
                    temp++;
                }else if(arr[y][x] > 1) {
                    arr[y][x]--;
                }
            }else if (!visited[ny][nx]){
                dfs(arr, visited, ny, nx, depth + 1);
            }
        }
    }


}
