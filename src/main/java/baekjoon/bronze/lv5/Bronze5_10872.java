package baekjoon.bronze.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 팩토리얼
 * 문제
 * 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 정수 N(0 ≤ N ≤ 12)이 주어진다.
 *
 * 출력
 * 첫째 줄에 N!을 출력한다.
 *
 * 입력1
 * 10
 * 출력1
 * 3628800
 */
public class Bronze5_10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        System.out.println(factorial(num));
    }

    private static int factorial(int num) {
        if (num <= 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }
}
