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

        Map<Integer, String> num = new HashMap<>();
        Map<String, Integer> name = new HashMap<>();


        for (int i = 1; i <= n; i++) {
            String s = bf.readLine();
            name.put(s, i);
            num.put(i, s);
        }

        for (int i = 0; i < m; i++) {
            String s = bf.readLine();
            if(s.charAt(0) >= '0' && s.charAt(0) <= '9') {
                System.out.println(num.get(Integer.parseInt(s)));
            } else {
                System.out.println(name.get(s));
            }
        }
    }
}
