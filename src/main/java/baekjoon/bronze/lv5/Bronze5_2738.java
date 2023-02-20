package baekjoon.bronze.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 행렬덧셈
 * 문제
 * N*M 크기의 두 행렬 A와 B가 주어졌을 때, 두 행렬을 더하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 행렬의 크기 N 과 M이 주어진다. 둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 차례대로 주어진다. 이어서 N개의 줄에 행렬 B의 원소 M개가 차례대로 주어진다. N과 M은 100보다 작거나 같고, 행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.
 *
 * 출력
 * 첫째 줄부터 N개의 줄에 행렬 A와 B를 더한 행렬을 출력한다. 행렬의 각 원소는 공백으로 구분한다.
 *
 * 입력1.
 * 3 3
 * 1 1 1
 * 2 2 2
 * 0 1 0
 * 3 3 3
 * 4 4 4
 * 5 5 100
 *
 * 출력1.
 * 4 4 4
 * 6 6 6
 * 5 6 100
 */
public class Bronze5_2738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        StringBuilder answer = new StringBuilder();

        int[][] arr1 = insertArray(row, col, br);
        int[][] arr2 = insertArray(row, col, br);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                answer.append(arr1[i][j] + arr2[i][j]).append(" ");
            }
            answer.append("\n");
        }

        System.out.println(answer);
    }

    private static int[][] insertArray(int row, int col, BufferedReader br) throws IOException {
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            StringTokenizer numSt = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(numSt.nextToken());
            }
        }
        return arr;
    }
}
