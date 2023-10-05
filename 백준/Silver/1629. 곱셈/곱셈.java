import java.io.*;
import java.util.*;
import java.util.function.Function;

/**
 *
 */
public class Main {
    static long A,B, C;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String, Long> sToN = Long::parseLong;
        A = sToN.apply(st.nextToken());
        B = sToN.apply(st.nextToken());
        C = sToN.apply(st.nextToken());

        // a^b%c => (a%c) * (b%c) % c
        System.out.println(calc(A, B));

    }

    static long calc(long a, long b) {

        // 지수가 1이면 현재 자신과 mod
        if (b == 1) {
            return a % C;
        }

        // 지수 절반 나누기
        long temp = calc(a, b / 2);

        // 지수가 홀수면 한번더 곱하기
        // ex) A^5%C => (A^2 % C) * (A^2%C) * A

        if (b % 2 == 1) {
            return (temp * temp % C) * A % C;
        }
        return temp * temp % C;
    }
}