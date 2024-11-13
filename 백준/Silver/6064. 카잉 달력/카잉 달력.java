import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            String[] input = bf.readLine().split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            int x = Integer.parseInt(input[2]);
            int y = Integer.parseInt(input[3]);

            int ans = getCnt(m, n, x, y);

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    public static int getCnt(int m, int n, int x, int y) {
        int cnt = x;
        while (cnt <= m * n) {
            if ((cnt - y) % n == 0) {
                return cnt;
            }
             cnt += m;
        }
        return -1;
    }
}


