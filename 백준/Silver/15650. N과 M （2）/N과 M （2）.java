import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        bt(n, m, 0, 1, sb);
    }

    private static void bt(int n, int m, int depth, int num, StringBuilder sb) {
        if (depth == m) {
            System.out.println(sb);
            return;
        }

        for(int i = num; i <= n; i++) {
            sb.append(i).append(" ");
            bt(n, m, depth + 1, i + 1, sb);
            sb.delete(sb.length() - 2, sb.length());
        }
    }


}
