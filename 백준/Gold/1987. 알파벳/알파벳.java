import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[][] arr;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];

        for (int i = 0; i < r; i++) {
            arr[i] = bf.readLine().toCharArray();
        }

        List<Character> list = new ArrayList<>();
        list.add(arr[0][0]);
        dfs(0, 0, list);

        System.out.println(result);
    }

    private static void dfs(int y, int x, List<Character> list) {


        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (check(ny, nx) || list.contains(arr[ny][nx])) continue;
            list.add(arr[ny][nx]);
            dfs(ny, nx, list);
            list.remove(list.size() - 1);
        }
        result = Math.max(result, list.size());
    }

    private static boolean check(int ny, int nx) {
        return ny < 0 || nx < 0 || ny >= arr.length || nx >= arr[0].length;
    }
}
