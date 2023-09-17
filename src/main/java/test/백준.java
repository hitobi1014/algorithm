package test;

import java.io.*;
import java.util.*;

/**
 *
 */
public class 백준 {
    static int N, M;
    static char[] S;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        S = br.readLine().toCharArray();

        int lt = 0;
        int answer = 0;
        A:while ((lt + (N * 2) + 1) < M) {

            if (S[lt] != 'I') {
                lt++;
                continue;
            }

            // 탐색문자열 만큼 for문
            for (int i = 0; i < (N * 2) + 1; i++) {
                if (i%2==0 && S[lt+i]=='I') continue;
                if (i%2==1 && S[lt+i]=='O') continue;
                lt++;
                continue A;
            }

            // 탐색문자열이 다 맞았을경우 cnt 증가와 lt를 N만큼 증가
            answer++;
            lt = N % 2 == 0 ? lt + N : lt + N + 1;
        }
        System.out.println(answer);
    }
}