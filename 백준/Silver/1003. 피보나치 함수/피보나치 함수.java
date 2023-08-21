import java.io.*;
import java.util.*;
import java.util.function.*;

public class Main {
    static Integer[][] answer;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> sToN = Integer::parseInt;
        int testCase = sToN.apply(br.readLine());
        answer = new Integer[41][2];
        for (int i = 0; i < testCase; i++) {
            int N = sToN.apply(br.readLine());
            answer[0][0] = 1;
            answer[0][1] = 0;
            answer[1][0] = 0;
            answer[1][1] = 1;
            fibonacci(N);
            sb.append(answer[N][0]).append(' ').append(answer[N][1]).append('\n');
        }
        System.out.println(sb.toString());
    }

    private static Integer[] fibonacci(int n) {
        if (answer[n][0] == null || answer[n][1] == null) {
            answer[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            answer[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
        }

        return answer[n];
    }
}