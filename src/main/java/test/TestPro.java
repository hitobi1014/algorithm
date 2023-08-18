package test;

import java.util.function.Function;

public class TestPro {
    public static void main(String[] args) {

        Function<String, Integer> function = num -> Integer.parseInt(num);
        Function<String, Integer> function2 = Integer::parseInt;

        System.out.println(function.apply("12301"));

    }
}
