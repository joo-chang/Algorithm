import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // 산성 용액 1 부터 10억까지 알칼리성 용액 -1 부터 -10억
        // 각각 0번째 부터 하나씩 증가하면서 이분탐색 진행
        int n = Integer.parseInt(bf.readLine());
        int startIndex = 0;
        int endIndex = 0;
        arr = new int[n];
        int result = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;
        int min = Integer.MAX_VALUE;
        int temp = 0;
        while (start < end) {
             temp = Math.abs(arr[start] + arr[end]);
            if (temp < min) {
                min = temp;
                startIndex = start;
                endIndex = end;
            }
            if ((arr[start] + arr[end]) > 0) {
                end--;
            } else {
                start++;
            }
        }
//        for (int i = 0; i < n; i++) {
//            int start = ;
//            int end = binarySearch(start, start + 1, arr.length - 1);
//
//            if (Math.abs(start + end) < result) {
//                result = Math.abs(arr[start] + arr[end]);
//                startIndex = start;
//                endIndex = end;
//            }
//        }
        StringBuilder sb = new StringBuilder();
        sb.append(arr[startIndex]).append(" ").append(arr[endIndex]);
        System.out.println(sb);
    }
    // -99 -2 -1 4 98
//    static int binarySearch(int target, int start, int end){
//        int min = Integer.MAX_VALUE;
//        int result = 0;
//        while (start < end) {
//            int mid = (start + end) / 2;
//            if (Math.abs(arr[target] + arr[mid]) < min) {
//                min = Math.abs(arr[target] + arr[start]);
//                result = mid;
//            }
//            if (arr[mid] < arr[target]) {
//                start = mid + 1;
//            } else if (arr[mid] > arr[target]) {
//                end = mid;
//            } else {
//                return target;
//            }
//        }
//        return result;
//    }

}
