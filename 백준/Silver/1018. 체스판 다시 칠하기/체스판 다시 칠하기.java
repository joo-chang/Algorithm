import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i = 0; i< n; i++){
            String temp = bf.readLine();
            for (int j = 0; j < m; j++){
                arr[i][j] = temp.charAt(j);
            }
        }

        for(int i = 0; i < n-7; i++){
            for(int j = 0; j < m-7; j++){
                check(arr, i, j);
            }
        }
        System.out.println(answer);
    }

    private static void check(int[][] arr, int y, int x) {
        int count = 0;
        for(int i = y; i < y+8; i++){
            for(int j = x; j < x+8; j++){
                if((i+j)%2 == 0){
                    if(arr[i][j] != 'W'){
                        count++;
                    }
                }else{
                    if(arr[i][j] != 'B'){
                        count++;
                    }
                }
            }
        }
        answer = Math.min(answer, count);
        count = 0;
        for(int i = y; i < y+8; i++){
            for(int j = x; j < x+8; j++){
                if((i+j)%2 == 0){
                    if(arr[i][j] != 'B'){
                        count++;
                    }
                }else{
                    if(arr[i][j] != 'W'){
                        count++;
                    }
                }
            }
        }
        answer = Math.min(answer, count);

    }
}
