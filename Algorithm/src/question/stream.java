package question;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class stream {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3);
//        intList.question.stream().filter(x-> x<3).map(x -> x*x).forEach(System.out::println);
        Arrays.asList(intList, Arrays.asList(2, 5)).stream()
                .flatMap(i -> i.stream())
                .forEach(System.out::println);
    }
}
