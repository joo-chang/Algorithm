package prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk_g3_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        long[] count = new long[m];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                arr[i] = Integer.parseInt(st.nextToken());
            }else {
                arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
            }
            count[(int)(arr[i] % m)]++;
        }

        long result = count[0];
        for (int i = 0; i < m; i++) {
            if (count[i] < 2) continue;
            result += count[i] * (count[i] - 1) / 2;
        }
        System.out.println(result);
    }
}
