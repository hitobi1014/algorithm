import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    static int[] fiboMod;

    public static void main(String[] args) throws Exception {
        int m = 6;
        int mod = (int) Math.pow(10, m);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger N = new BigInteger(br.readLine());

        // 피사노 주기 구하기
        int p = 15 * (int) Math.pow(10, (m - 1));
        fiboMod = new int[p];

        fiboMod[0] = 0;
        fiboMod[1] = 1;

        // 피보나치를 mod로 나눈값의 나머지를 주기 길이만큼 input
        for (int i = 2; i < p; i++) {
            fiboMod[i] = (fiboMod[i - 2] + fiboMod[i - 1]) % mod;
        }

        int idx = N.mod(BigInteger.valueOf(p)).intValue();
        System.out.println(fiboMod[idx]);

    }

}