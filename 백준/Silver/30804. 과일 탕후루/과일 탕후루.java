import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {

    // 1. 순서대로 개수 체크
    // 2. 양쪽 값을 비교해서 더 작은 수 빼기
    // 3. 종류가 두 개 남을 때까지 반복
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int right = 0; right < n; right++) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            while (map.size() > 2) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }

        System.out.println(max);
    }
}


