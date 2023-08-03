package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2001. 파리 퇴치 푸는중
public class Main {

    static StringBuilder sb = new StringBuilder();
    // N*N 배열
    // M*M 크기의 최대 파리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N+1][N+1];

            // 2차원배열 입력 => 누적합 만들기
            for (int r = 1; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 1; c < N; c++) {
//                    arr[r][c] = Integer.parseInt(st.nextToken());
                    arr[r][c] = arr[r - 1][c] + arr[r][c - 1] - arr[r - 1][c - 1] + Integer.parseInt(st.nextToken());
                }
            }

            sb.append('#').append(i).append(" ");
            // solution
            // 누적합 만들기


        }

    }


    static void solution(int[][] arr, int N, int M){
        int max = Integer.MIN_VALUE;



    }


}
