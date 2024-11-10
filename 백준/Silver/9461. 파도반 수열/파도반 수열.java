import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        long[] arr = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;
        for (int i = 6; i < 101; i++) {
            arr[i] = arr[i-1] + arr[i-5];
        }
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bf.readLine());
            System.out.println(arr[n]);
        }
    }
}
