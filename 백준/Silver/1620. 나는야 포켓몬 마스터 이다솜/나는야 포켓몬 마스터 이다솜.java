import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> name = new HashMap<>();
        String[] num = new String[n + 1];


        for (int i = 1; i <= n; i++) {
            String s = bf.readLine();
            name.put(s, i);
            num[i] = s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String s = bf.readLine();
            if(s.charAt(0) >= '0' && s.charAt(0) <= '9') {
                sb.append(num[Integer.parseInt(s)]).append("\n");
            } else {
                sb.append(name.get(s)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
