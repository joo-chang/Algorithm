import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(bf.readLine()));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}