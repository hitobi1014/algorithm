import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
    static int N, S, numbers[];
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> sToN = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = sToN.apply(st.nextToken());
        S = sToN.apply(st.nextToken());
        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = sToN.apply(st.nextToken());
        }
        permutation();

        System.out.println(answer);
    }

    private static void permutation() {
        for (int i = 1; i < 1 << N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                // 선택된 원소라면 sum
                if ((i & (1 << j)) != 0) sum += numbers[j];
            }
            if (sum == S) answer++;
        }
    }

}