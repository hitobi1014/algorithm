import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    static BigInteger[] fibonacci;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        fibonacci = new BigInteger[10001];
        init(N);

        System.out.println(fibonacci[N]);
    }

    static void init(int N) {
        fibonacci[0] = new BigInteger("0");
        fibonacci[1] = new BigInteger("1");
        for (int i = 2; i <= N; i++) {
            fibonacci[i] = fibonacci[i - 2].add(fibonacci[i - 1]);
        }
    }
}