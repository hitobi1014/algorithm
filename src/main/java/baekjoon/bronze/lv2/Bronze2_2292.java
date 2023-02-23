package baekjoon.bronze.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2292
 * 벌집
 */
public class Bronze2_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int a = 1, b = 1;
        int answer = 1;

        while (true) {
            if (num == 1) break;

            if (a <= num && num <= b) break;

            a += 6 * (answer - 1);
            b += 6 * (answer);

            if (a == 1) a = 2;

            answer++;
        }

        System.out.println(answer);
    }
}
