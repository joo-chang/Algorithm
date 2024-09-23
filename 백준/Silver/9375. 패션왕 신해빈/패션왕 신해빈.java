import java.io.*;
import java.util.HashMap;
import java.util.Map;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(bf.readLine());

            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < m; j++) {
                String[] str = bf.readLine().split(" ");
                map.put(str[1], map.getOrDefault(str[1], 0) + 1);
            }
            // key 가 겹치지 않는 모든 경우의 수 구하기
            int result = 1;

            for (String key : map.keySet()) {
                result *= map.get(key) + 1;
            }
            sb.append(result - 1).append("\n");
        }
        System.out.println(sb);
    }
}
