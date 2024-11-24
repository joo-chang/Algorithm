import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<String> list = new ArrayList<>();
        Set<String> hear = new HashSet<>();

        for (int i = 0; i < n; i++) {
            hear.add(bf.readLine());
        }
        for (int i = 0; i < m; i++) {
            String listen = bf.readLine();
            if (hear.contains(listen)) {
                list.add(listen);
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
