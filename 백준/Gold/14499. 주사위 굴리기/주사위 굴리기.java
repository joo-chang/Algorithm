import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int[] dx = {0, 0, 0, -1, 1};
        int[] dy = {0, 1, -1, 0, 0};
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dice dice = new Dice(0,0,0,0,0,0);

        st = new StringTokenizer(bf.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < k; i++) {
            int dir = Integer.parseInt(st.nextToken());
            if (check(y + dy[dir], x + dx[dir])) continue;

            x += dx[dir];
            y += dy[dir];
            int temp = dice.b;
            switch (dir) {
                case 1:
                    dice.b = dice.r;
                    dice.r = dice.t;
                    dice.t = dice.l;
                    dice.l = temp;
                    break;
                case 2:
                    dice.b = dice.l;
                    dice.l = dice.t;
                    dice.t = dice.r;
                    dice.r = temp;
                    break;
                case 3:
                    dice.b = dice.u;
                    dice.u = dice.t;
                    dice.t = dice.d;
                    dice.d = temp;
                    break;
                case 4:
                    dice.b = dice.d;
                    dice.d = dice.t;
                    dice.t = dice.u;
                    dice.u = temp;
                    break;
            }
            if (map[x][y] == 0) {
                map[x][y] = dice.b;
            } else {
                dice.b = map[x][y];
                map[x][y] = 0;
            }
            sb.append(dice.t).append("\n");
        }
        System.out.println(sb);
    }
    static class Dice{
        int b, t, u, d, r, l;

        public Dice(int bottom, int top, int up, int down, int right, int left){
            this.b = bottom;
            this.t = top;
            this.u = up;
            this.d = down;
            this.r = right;
            this.l = left;
        }
    }
    static boolean check(int y, int x){
        return y < 0 || x < 0 || x >= n || y >= m;
    }
}
