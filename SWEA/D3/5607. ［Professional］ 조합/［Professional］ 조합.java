import java.io.*;
import java.util.*;

/**
 *
 */
public class Solution {
    static final int MOD = 1234567891;
    static long factorial[] = new long[1000001];
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        init();

        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++){
            int N = sc.nextInt();
            int K = sc.nextInt();

            long c1 = factorial[N];
            long c2 = (factorial[N-K] * factorial[K]) % MOD;
            long c3 = calculatePow(c2, MOD-2);

            sb.append("#").append(tc).append(" ");
            sb.append(c1 * c3 % MOD).append("\n");
        }
        System.out.println(sb);
    }
    //분할정복으로 구하면 O(logN)만에 구할수 있다.
    private static long calculatePow(long n, long k) {
        if(k == 1){
            return n;
        }
        long x = calculatePow(n, k/2) % MOD;
        if(k % 2 == 0){
            return x * x % MOD;
        }else{
            return ((x * x) % MOD * n) % MOD;
        }
    }

    private static void init() {
        factorial[0] = 1;
        for(int i=1; i<=1000000; i++){
            factorial[i] = factorial[i-1] * i % MOD;
        }
    }


}