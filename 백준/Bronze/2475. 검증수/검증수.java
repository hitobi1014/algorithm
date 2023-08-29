import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total=0;
        total = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .map(n -> (int) Math.pow(n, 2))
                .sum();

        System.out.println(total%10);
    }

}