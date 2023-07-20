package 인프런.section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 설명
 * 현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
 * 만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
 * 12 1511 20 2510 20 19 13 15
 * 연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
 * 여러분이 현수를 도와주세요.
 *
 * 입력
 * 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
 * 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
 *
 * 출력
 * 첫 줄에 최대 매출액을 출력합니다.
 *
 * 예시입력
 * 10 3
 * 12 15 11 20 25 10 20 19 13 15
 *
 * 출력
 * 56
 */
public class _03_최대매출 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] sales = new int[n];

        for (int i = 0; i < sales.length; i++) {
            sales[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(soultion(n,k,sales));
    }

    public static int soultion(int n, int k, int[] sales){
        int answer = 0, sum = 0;

        for (int i = 0; i < k; i++) sum += sales[i];
        answer = sum;

        for (int i = k; i < n; i++) {
            sum += (sales[i] - sales[i - k]);
            answer = Math.max(answer, sum);
        }
//        int max = Integer.MIN_VALUE;
//
//        for (int i = 0; i < sales.length; i++) {
//            int total = 0;
//            if (i+k > n) break;
//
//            for (int j = i; j < i + k; j++) {
//                total += sales[j];
//            }
//
//            if (total > max) max = total;
//        }
//
//        answer = max;

        return answer;
    }

}
