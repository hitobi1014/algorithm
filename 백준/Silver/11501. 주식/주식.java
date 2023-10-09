import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] map = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            // input
            for (int j = 0; j < N; j++) {
                map[j] = Integer.parseInt(st.nextToken());
            }

            long answer = profit(map, N);
            sb.append(answer).append('\n');
        }

        System.out.println(sb);
    }

    static long profit(int[] map, int N) {
        long total = 0;
        long maxPrice = Integer.MIN_VALUE;
        long diffPrice;

        for (int i = N - 1; i >= 0; i--) {
            long curPrice = map[i];
            diffPrice = 0;
            if (curPrice > maxPrice) {
                maxPrice = curPrice;
            } else if (curPrice < maxPrice){
                diffPrice = maxPrice - curPrice;
            }
            total += diffPrice;
        }

        return total;
    }
}