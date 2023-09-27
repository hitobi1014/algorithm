package test;

import java.io.*;
import java.util.*;

/**
 */
public class Swea {
    static int t, n; // 테케, 편의점수
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        /**
         * n+2만큼 배열 선언
         * 해당 배열을 0~ n+2, 각 좌표별로 차이를 할당 (x+y값의 차이)
         * ex) 입력이
         * 0 0
         * 1000 0
         * 1000 1000
         * 2000 1000
         *    0     1     2     3
         * 0  0     1000  2000  3000
         * 1  1000  0     1000  2000
         * 2  2000  1000  0     1000
         * 3  3000  2000  1000   0
         *
         * 플로이드 워셜을 활용해서 모든 정점에 대해 차이
         * if Math.Min(  abs(map[i][k] - map[k][j]) , map[i][j])
         */
    }
}