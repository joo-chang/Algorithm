package prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk_s4_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];

        // 누적합 구하기
        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 1;
        int count = 0;

        while (end <= n && start < n) {
            if (arr[end] - arr[start] < m) {
                end++;
            } else if (arr[end] - arr[start] > m) {
                start++;
            } else {
                count++;
                end++;
                start++;
            }
        }

        System.out.println(count);
    }
}
