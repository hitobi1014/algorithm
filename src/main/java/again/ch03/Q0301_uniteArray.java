package again.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 설명
 * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
 * 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
 * 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
 * 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
 * 각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
 *
 * 출력
 * 오름차순으로 정렬된 배열을 출력합니다
 */
public class Q0301_uniteArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 배열1 크기
        int[] arr1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine()); // 배열2 크기
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < m; j++) {
            arr2[j] = Integer.parseInt(st.nextToken());
        }

        int[] total = new int[arr1.length + arr2.length];

        // 배열1 크기만큼 반복
        // 배열2 크기만큼 반복
        // 크기가 각 각 다름
        int i = 0, j = 0, k = 0;

        // arr1, arr2 비교해서 total 넣기
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                total[k] = arr1[i];
                i++;
            } else {
                total[k] = arr2[j];
                j++;
            }
            k++;
        }

        // 남은 배열 삽입하기
        if (i == arr1.length) {
            for (int a = j; a < arr2.length; a++) {
                total[k] = arr2[a];
                k++;
            }
        } else if (j == arr2.length) {
            for (int b = i; b < arr1.length; b++) {
                total[k] = arr1[b];
                k++;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int a : total) {
            answer.append(a).append(" ");
        }
        System.out.println(answer);
    }
}
