import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        int[] c = new int[k];
        long result = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        list.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        for (int i = 0; i < k; i++) {
            c[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(c);

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        for (int i = 0; i < k; i++) {
            while (idx < n && list.get(idx)[0] <= c[i]) {
                int[] arr = list.get(idx++);
                queue.offer(arr[1]);
            }
            if (!queue.isEmpty()) result += queue.poll();
        }
        System.out.println(result);

    }
}
