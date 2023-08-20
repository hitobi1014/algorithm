import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
    static int N, M;
    static boolean[] isPrime;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> sToN = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = sToN.apply(st.nextToken());
        M = sToN.apply(st.nextToken());
        isPrime = new boolean[M+1];
        isPrime[1] = true;
        makePrime();
        printPrime();
    }

    private static void makePrime() {
        for (int i = 2; i <= M; i++) {
            if(isPrime[i]) continue;
            for (int j = i * 2; j <= M; j += i) {
                isPrime[j] = true;
            }
        }
    }

    private static void printPrime() {
        StringBuilder sb = new StringBuilder();
        for (int i = N; i <= M; i++) {
            if (!isPrime[i]) sb.append(i).append('\n');
        }

        System.out.println(sb.toString());
    }

}