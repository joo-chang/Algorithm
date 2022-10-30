package question;

public class book02 {
    public static void main(String[] args) {
        int[] a = {17, 92, 18, 33, 58, 7, 33, 42};
        int result = getBigger(a);
        System.out.println(result);
    }

    public static int getBigger(int[] a){

        int result = 0;

        for (int i=0; i<a.length; i++){
            result = a[result] >= a[i] ? result : i;
        }

        return result;
    }
}
