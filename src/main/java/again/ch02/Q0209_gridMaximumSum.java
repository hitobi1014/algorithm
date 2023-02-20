package again.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 설명
 * 5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
 * N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
 *
 * 입력
 * 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
 * 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
 *
 * 출력
 * 최대합을 출력합니다.
 *
 * 예시 입력 1
 * 5
 * 10 13 10 12 15
 * 12 39 30 23 11
 * 11 25 50 53 15
 * 19 27 29 37 27
 * 19 13 30 13 19
 *
 * 예시 출력
 * 155
 */
public class Q0209_gridMaximumSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int[][] numArr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                numArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // a: 행 sum , b: 열 sum, c: 좌측위->우측아래, d: 좌측아래 -> 우측위
        int c = 0, d = 0;
        for (int i = 0; i < n; i++) {
            int a = 0;
            int b = 0;

            for (int j = 0; j < n; j++) {
                a += numArr[i][j];
                b += numArr[j][i];
            }

            c += numArr[i][i];
            d += numArr[i][n - i - 1];
            max = Math.max(max, Math.max(a, b));
        }

        System.out.println(Math.max(max, Math.max(c, d)));
    }
}
