package baekjoon.bronze.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 수 정렬하기
 * https://www.acmicpc.net/problem/2750
 * <p>
 * 문제
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
 * <p>
 * 출력
 * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 * <p>
 * 예제입력
 * 5
 * 5
 * 2
 * 3
 * 4
 * 1
 * 예제출력
 * 1
 * 2
 * 3
 * 4
 * 5
 */
public class Bronze2_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int[] arr = new int[cnt];

        // 한줄씩 숫자입력
        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        insertionSort(arr);

        for (int x : arr) {
            System.out.println(x);
        }
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int prev = i-1;
            while (prev >= 0 && arr[prev] > temp) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = temp;
        }
    }
}
