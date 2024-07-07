import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int result = 0;
        for (int i = 1; i < n; i++) {
            int temp = i;
            int num = i;
            while(temp > 0){
                num += temp % 10;
                temp /= 10;
            }
            if (num == n){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
