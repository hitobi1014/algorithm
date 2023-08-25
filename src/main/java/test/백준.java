package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/**
 * N번째 큰 수
 * N*N = N^2
 */
public class 백준 {
    static int N, arr[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // 모든 수는 자신의 한 칸 위에있는 수 보다 크다..
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            arr[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[] idx = new int[2];
        int cnt=1;

        int max = Integer.MIN_VALUE;
        for (int col = 0; col < N; col++) {
            if (arr[N - 1][col] > max) {
                max = arr[N - 1][col];
                idx[0] = N - 1;
                idx[1] = col;
            }
        }

        idx[0]--;

        /**
         * 5
         * 12 7 9 15 5
         * 13 8 11 19 6
         * 21 10 26 31 16
         * 48 14 28 35 25
         * 52 20 32 41 49
         */

        while (cnt < N) {
            int rowMax = 0;
            int colMax = 0;

            for (int col = idx[1]; col < N; col++) {

            }
        }

        queue.stream().sorted(Collections.reverseOrder()).skip(N-1).limit(1).forEach(System.out::println);
    }

}