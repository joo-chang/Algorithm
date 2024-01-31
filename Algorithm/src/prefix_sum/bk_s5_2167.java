package prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk_s5_2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] pArr = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j < m + 1; j++) {
                pArr[i][j] = Integer.parseInt(st.nextToken()) + pArr[i - 1][j] + pArr[i][j - 1] - pArr[i - 1][j - 1];
            }
        }

        int k = Integer.parseInt(bf.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(bf.readLine());
            int[] area = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            System.out.println(pArr[area[2]][area[3]] - pArr[area[0] - 1][area[3]] - pArr[area[2]][area[1] - 1] + pArr[area[0] - 1][area[1] - 1]);
        }
    }
}
