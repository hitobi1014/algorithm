package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Q.
 * N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
 *
 * Input.
 * 첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.
 *
 * Output.
 * 입력으로 주어진 숫자 N개의 합을 출력한다
 *
 * 예제입력
 * 5
 * 54321
 *
 * 예제출력
 * 15
*/
public class Bronze4_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String[] numArr = br.readLine().split("");
        int answer = 0;

        for (int i=0; i<count; i++) {
            answer += Integer.parseInt(numArr[i]);
        }
        System.out.println(answer);
    }
}
