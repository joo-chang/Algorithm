import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static boolean[][] arr;
    static int blue = 0;
    static int white = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        arr = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }
        func(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void func(int y, int x, int n) {
        if (check(y, x, n)) {
            if (arr[y][x]) blue++;
            else white++;
            return;
        }
        n /= 2;
        func(y, x, n);
        func(y + n, x, n);
        func(y, x + n, n);
        func(y + n, x + n, n);
    }

    private static boolean check(int y, int x, int n) {
        boolean color = arr[y][x];

        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (color != arr[i][j]) return false;
            }
        }
        return true;
    }

}
