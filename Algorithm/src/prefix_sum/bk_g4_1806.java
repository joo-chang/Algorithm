package prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk_g4_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 1;
        int result = Integer.MAX_VALUE;
        if (arr[n] < s) {
            System.out.println("0");
            return;
        }
        while (end <= n && start < n) {
            if (end == start) {
                System.out.println("1");
                return;
            }
            if (arr[end] - arr[start] >= s) {
                result = Math.min(result, end - start);
                start++;
            }else end++;
        }

        System.out.println(result);

    }
}
