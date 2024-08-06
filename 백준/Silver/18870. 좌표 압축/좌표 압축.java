import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long[] answer = new long[n];
        long[] arr = new long[n];
        Map<Long, ArrayList<Integer>> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        int idx = 0;
        for (Long key : map.keySet()) {
            for (int i : map.get(key)) {
                answer[i] = idx;
            }
            idx++;
        }
        StringBuilder sb = new StringBuilder();
        for (long l : answer) {
            sb.append(l).append(" ");
        }
        System.out.println(sb);
    }
}
