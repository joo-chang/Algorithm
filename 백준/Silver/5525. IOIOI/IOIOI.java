import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());
        int[] arr = new int[m];
        String line = bf.readLine();
        for (int i = 0; i < m; i++) {
            arr[i] = line.charAt(i) - '0';
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("IO");
        }
        sb.append("I");

        String pattern = sb.toString();

        int count = 0;
        for (int i = 0; i < m - n * 2; i++) {
            if (line.substring(i, i + n * 2 + 1).equals(pattern)) {
                count++;
            }
        }
        System.out.println(count);
    }


}