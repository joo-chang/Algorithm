import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[][] arr;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            arr = new int[m][n];
            int bug = 0;

            // arr 세팅
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(bf.readLine());
                arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            // 모든 배열 방문하면서 dfs 수행
            for (int j = 0; j < m; j++) {
                for (int l = 0; l < n; l++) {
                    if(arr[j][l] == 1){
                        dfs(j, l);
                        bug++;
                    }
                }
            }

            sb.append(bug).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int y, int x) {
        // 방문 배열 대신 1을 0으로 변경
        arr[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;

            if (check(ny, nx)) continue;
            if (arr[ny][nx] == 1){
                dfs(ny, nx);
            }
        }

    }

    private static boolean check(int ny, int nx) {
        return ny < 0 || nx < 0 || ny >= arr.length || nx >= arr[0].length;
    }

}
