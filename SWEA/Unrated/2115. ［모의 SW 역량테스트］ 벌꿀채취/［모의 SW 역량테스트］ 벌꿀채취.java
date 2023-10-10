import java.io.*;
import java.util.*;
import java.util.function.*;

public class Solution {
    static int N, M, C, maxNum;
    static int[][] map;
    static boolean[][] selected;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testCase; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            // map input
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // logic start
            selected = new boolean[N][N];
            int answer = 0;
            answer = combination();
            System.out.printf("#%d %d\n",tc, answer);
        }
    }

    /**
     * 2개로 조합
     */
    static int combination() {
        int result = 0;
        int max1 = 0;
        int max2 = 0;

        for (int i = 0; i < N; i++) {
            // 선택할 수 있는 벌통(열)까지
            for (int j = 0; j <= N - M; j++) {
                // 일꾼1 선택
                maxNum = 0;
                getMaxHoney(i, j, 0, 0, 0);
                max1 = maxNum;

                // 일꾼2 선택
                maxNum = 0;
                max2 = 0;
                // 일꾼1이 선택한 다음 벌통 열에서 시작
                for (int j2 = j + M; j2 <= N - M; j2++) {
                    getMaxHoney(i, j2, 0, 0, 0);
                    max2 = Math.max(max2, maxNum);
                }

                // 일꾼2 다른 행부터 선택
                for (int i2 = i + 1; i2 < N; i2++) {
                    for (int j2 = 0; j2 <= N - M; j2++) {
                        getMaxHoney(i2, j2, 0, 0, 0);
                        max2 = Math.max(max2, maxNum);
                    }
                }

                result = Math.max(result, max1 + max2);
            }
        }

        return result;
    }

    static void getMaxHoney(int i, int j, int cnt, int sum, int profit) {
        // 채취한 꿀이 최대 양 넘기면 stop
        if (sum > C) return;

        // 벌통 M개 선택했으면 이익 갱신
        if (cnt == M) {
            if (maxNum <= profit) maxNum = profit;
            return;
        }

        // 벌꿀 선택o
        getMaxHoney(i, j+1, cnt+1, sum+map[i][j], (int) (profit + Math.pow(map[i][j],2)));

        // 벌꿀 선택x
        getMaxHoney(i, j+1, cnt+1, sum, profit);
    }

}