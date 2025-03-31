import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int minPackage = Integer.MAX_VALUE;
        int minUnit = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int pack = Integer.parseInt(st.nextToken());
            int unit = Integer.parseInt(st.nextToken());

            minPackage = Math.min(minPackage, pack);
            minUnit = Math.min(minUnit, unit);
        }

        int unitMoney = 0;
        int packMoney = 0;

        unitMoney = minUnit * N;

        int cnt = Math.max(N / 6, 1);
        packMoney = cnt * minPackage;

        if (N % 6 != 0) {
            int a = (N%6) * minUnit;
            packMoney += Math.min(a, minPackage);
        }

        System.out.println(Math.min(unitMoney, packMoney));
    }

}