import java.io.*;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] arr = new String[n];
        for(int i=0; i<n; i++){
            arr[i] = bf.readLine();
        }
        Arrays.stream(arr).sorted((a,b) -> {
            if(a.length() == b.length()){
                return a.compareTo(b);
            }else{
                return a.length() - b.length();
            }
        }).distinct().forEach(System.out::println);
    }
}
