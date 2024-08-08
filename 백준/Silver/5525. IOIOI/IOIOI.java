import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());
        int answer = 0;
        int count = 0;
        String line = bf.readLine();

        for (int i = 1; i < m - 1; ) {
            if (line.charAt(i) == 'O' && line.charAt(i + 1) == 'I') {
                count++;
                if (count == n) {
                    if (line.charAt(i - (n * 2 - 1)) == 'I') {
                        answer++;
                    }
                    count--;
                }
                i += 2;
            } else {
                i++;
                count = 0;
            }
        }
        System.out.println(answer);
    }
}