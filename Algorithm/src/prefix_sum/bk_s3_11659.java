package prefix_sum;

import java.io.*;
import java.util.*;

class bk_s3_11659 {
	public static void main(String[] arges) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] sum = new int[N+1];
		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= N; i++) {
			sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
		}
		for (int k = 0; k < M; k++) {
			st = new StringTokenizer(bf.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			System.out.println(sum[j] - sum[i - 1]);
		}
	}
}