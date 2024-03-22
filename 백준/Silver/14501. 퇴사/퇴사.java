import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int result = Integer.MIN_VALUE;
    static int[][] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        bt(0, 0);

        System.out.println(result);
    }

    private static void bt(int idx, int pay) {
        if (idx >= n) {
            result = Math.max(result, pay);
            return;
        }

        if (idx + arr[idx][0] <= n) {
            bt(idx + arr[idx][0], pay + arr[idx][1]);
        } else {
            bt(idx + arr[idx][0], pay);
        }
        bt(idx + 1, pay);
    }

}
