import java.io.*;
import java.util.*;

public class Solution {
    static int N, max;
    static int[] trees;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine()); // 나무 개수
            trees = new int[N];
            max = 0;

            // map input
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                trees[i] = Integer.parseInt(st.nextToken());
                if (max < trees[i]) max = trees[i];
            }

            // 1, 2 개수 구하기
            int even=0, odd=0;
            for (int i = 0; i < N; i++) {
                int diff = max - trees[i];
                if(diff==0) continue;

                even += diff / 2;
                odd += diff % 2;
            }

            // 2를 1로
            if (even > odd) {
                while (Math.abs(even - odd) > 1) {
                    even--;
                    odd +=2;
                }
            }

            int result = 0;
            // 1이 많을 경우
            if (odd > even) {
                result = odd * 2 - 1;
            }
            // 2가 많을 경우
            else if (even > odd) {
                result = even * 2;
            }
            // 1,2 숫자가 같은 경우
            else {
                result = even + odd;
            }

            System.out.printf("#%d %d\n", t, result);
        }
    }

}