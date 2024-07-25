import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            String[] oper = bf.readLine().split(" ");
            int n = 0;
            if (oper.length == 2) {
                n = Integer.parseInt(oper[1]);
            }

            switch (oper[0]) {
                case "add":
                    set.add(n);
                    break;
                case "remove":
                    set.remove(n);
                    break;
                case "check":
                    if(set.contains(n)){
                        sb.append("1");
                    }else{
                        sb.append("0");
                    }
                    sb.append("\n");
                    break;
                case "toggle":
                    if (set.contains(n)) {
                        set.remove(n);
                    } else {
                        set.add(n);
                    }
                    break;
                case "all":
                    for (int j = 1; j <= 20; j++) {
                        set.add(j);
                    }
                    break;
                case "empty":
                    set = new HashSet<>();
                    break;
            }
        }
        System.out.println(sb);
    }


}
