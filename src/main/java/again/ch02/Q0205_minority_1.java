package again.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 설명
 * 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
 * 만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
 *
 * 입력
 * 첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
 *
 * 출력
 * 첫 줄에 소수의 개수를 출력합니다.
 *
 * 예시 입력 1
 * 20
 *
 * 예시 출력
 * 8
 */
public class Q0205_minority_1 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int answer = 0;

        boolean[] minority = new boolean[count + 1];
        minority[0] = true;
        minority[1] = true;
        int j = 0;

        for (int i = 2; i< (int) Math.sqrt(count) + 1; i++) {
            if(!minority[i]) j = 2;

            while (i * j <= count) {
                minority[i * j] = true;
                j++;
            }
        }

        for (boolean x : minority) {
            if(!x) answer++;
        }

        System.out.println(answer);

        long end = System.currentTimeMillis();
        System.out.println((end-start) + "ms");
    }
}
