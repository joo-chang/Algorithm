package question;

import java.util.ArrayList;

public class book03 {
    public static void main(String[] args) {
        String[] a = {"Tom", "Jerry", "Mike", "Tom"};
        System.out.println(sameName(a));
    }

    private static ArrayList<String> sameName(String[] a) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i].equals(a[j])){
                    result.add(a[i]);
                }
            }
        }
        return result;
    }
}
