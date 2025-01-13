import java.io.*;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Loop1:
        while (true) {
            String word = bf.readLine();
            if (word.equals("0")) {
                break;
            }
            if (word.charAt(0) == '0') {
                sb.append("no").append("\n");
                continue;
            }
            int num = Integer.parseInt(word);
            for (int i = 1; i <= word.length()/2; i++) {
                if (!(word.charAt(i - 1)  - '0' == num % 10) ){
                    int a = word.charAt(i - 1) - '0';
                    int b = num % 10;
                    sb.append("no").append("\n");
                    continue Loop1;
                }
                num /= 10;
            }
            sb.append("yes").append("\n");
        }
        System.out.println(sb);
    }
}