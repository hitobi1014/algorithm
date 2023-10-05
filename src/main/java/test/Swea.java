package test;

import java.io.*;
import java.util.*;
import java.util.function.*;

/**
 */
public class Swea {
    static int[] selected;
    static int N,W,H;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> sToN = Integer::parseInt;
        int testCase = sToN.apply(br.readLine());

        for (int tc = 1; tc <= testCase; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = sToN.apply(st.nextToken()); // 구슬 개수
            W = sToN.apply(st.nextToken()); // 너비
            H = sToN.apply(st.nextToken()); // 높이

            map = new int[H][W];

            // 중복 순열 => 너비 idx

            int answer = 0;
            System.out.printf("%d %d", tc, answer);
        }

    }

    // 구슬 쏘기 idx 중복순열만들기
    static void permutation(int cnt) {
        // 구슬개수
        if (cnt == N) {

            int[][] mapCopy = map.clone();

            // 선택된 idx 차례로 쏘기
            for (int i = 0; i < cnt; i++) {
                int curIdx = selected[i];
                shoot(curIdx, mapCopy);
            }

            return;
        }

        for (int i = 0; i < W; i++) {
            selected[cnt] = i;
            permutation(cnt + 1);
        }

    }

    static void shoot(int curIdx, int[][] copy) {
        for (int i = 0; i < H; i++) {
            if (copy[i][curIdx] == 0) continue;
        }
    }
}