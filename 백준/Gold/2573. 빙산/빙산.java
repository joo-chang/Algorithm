import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    /**
     * 백준 2573 빙산
     * 지구 온난화로 인하여 북극의 빙산이 녹고 있다. 빙산을 그림 1과 같이 2차원 배열에 표시한다고 하자. 빙산의 각 부분별 높이 정보는 배열의 각 칸에 양의 정수로 저장된다. 빙산 이외의 바다에 해당되는 칸에는 0이 저장된다. 그림 1에서 빈칸은 모두 0으로 채워져 있다고 생각한다.
     * 빙산의 높이는 바닷물에 많이 접해있는 부분에서 더 빨리 줄어들기 때문에, 배열에서 빙산의 각 부분에 해당되는 칸에 있는 높이는 일년마다 그 칸에 동서남북 네 방향으로 붙어있는 0이 저장된 칸의 개수만큼 줄어든다. 단, 각 칸에 저장된 높이는 0보다 더 줄어들지 않는다. 바닷물은 호수처럼 빙산에 둘러싸여 있을 수도 있다. 따라서 그림 1의 빙산은 일년후에 그림 2와 같이 변형된다.
     * 한 덩어리의 빙산이 주어질 때, 이 빙산이 두 덩어리 이상으로 분리되는 최초의 시간(년)을 구하는 프로그램을 작성하시오. 그림 1의 빙산에 대해서는 2가 답이다. 만일 전부 다 녹을 때까지 두 덩어리 이상으로 분리되지 않으면 프로그램은 0을 출력한다.
     *
     * 입력
     * 첫 줄에는 이차원 배열의 행의 개수와 열의 개수를 나타내는 두 정수 N과 M이 한 개의 빈칸을 사이에 두고 주어진다. N과 M은 3 이상 300 이하이다. 그 다음 N개의 줄에는 각 줄마다 배열의 각 행을 나타내는 M개의 정수가 한 개의 빈 칸을 사이에 두고 주어진다. 각 칸에 들어가는 값은 0 이상 10 이하이다. 배열에서 빙산이 차지하는 칸의 개수, 즉, 1 이상의 정수가 들어가는 칸의 개수는 10,000 개 이하이다. 배열의 첫 번째 행과 열, 마지막 행과 열에는 항상 0으로 채워진다.
     *
     * 출력
     * 첫 줄에 빙산이 분리되는 최초의 시간(년)을 출력한다. 만일 빙산이 다 녹을 때까지 분리되지 않으면 0을 출력한다.
     */


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][] temp = new int[N][M];
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int year = 0;
        int cnt = 0;
        int result = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            cnt = 0;
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    if (map[i][j] != 0) {
                        for (int k = 0; k < 4; k++) {
                            int x = i + dir[k][0];
                            int y = j + dir[k][1];
                            if (map[x][y] == 0) {
                                temp[i][j]++;
                            }
                        }
                    }
                }
            }

            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    map[i][j] -= temp[i][j];
                    if (map[i][j] < 0) {
                        map[i][j] = 0;
                    }
                    temp[i][j] = 0;
                    if (map[i][j] != 0) {
                        cnt++;
                    }
                }
            }

            if (cnt == 0) {
                result = 0;
                break;
            }

            year++;

            List<int[]> list = new ArrayList<>();
            boolean[][] visited = new boolean[N][M];
            int iceberg = 0;

            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    if (map[i][j] != 0 && !visited[i][j]) {
                        iceberg++;
                        if (iceberg > 1) {
                            result = year;
                            break;
                        }
                        dfs(map, visited, i, j, N, M, list);
                    }
                }
            }

            if (result != 0) {
                break;
            }
        }
        System.out.println(result);
    }

    private static void dfs(int[][] map, boolean[][] visited, int i, int j, int n, int m, List<int[]> list) {
        visited[i][j] = true;
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int k = 0; k < 4; k++) {
            int x = i + dir[k][0];
            int y = j + dir[k][1];
            if (x >= 0 && y >= 0 && x < n && y < m && map[x][y] != 0 && !visited[x][y]) {
                dfs(map, visited, x, y, n, m, list);
            }
        }
    }


}
