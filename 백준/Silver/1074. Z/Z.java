import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int cnt = 0;
    static int[] dy = {0, 0, 1, 1};
    static int[] dx = {0, 1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        func(n, r, c, 0, 0);

    }

    private static void func(int n, int r, int c, int y, int x) {
        if(n == 1) {
            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                cnt++;
                if(ny == r && nx == c) {
                    System.out.println(cnt - 1);
                    System.exit(0);
                }
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = (int) (y + Math.pow(dy[i]*2, n - 1));
            int nx = (int) (x + Math.pow(dx[i]*2, n - 1));
            if(ny <= r && r < ny + (int) Math.pow(2, n - 1) && nx <= c && c < nx + (int) Math.pow(2, n - 1)) {
                func(n - 1, r, c, ny, nx);
            }else {
                cnt += (int) Math.pow(2, 2 * n - 2);
            }

        }

    }

}
