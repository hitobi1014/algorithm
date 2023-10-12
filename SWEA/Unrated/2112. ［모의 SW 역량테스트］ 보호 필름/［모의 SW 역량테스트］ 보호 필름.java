import java.io.*;
import java.util.*;

public class Solution {
    static int D,W, K, answer;
    static int[][] map, temp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testCase; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[D][W];
            temp = new int[D][W];
            answer = Integer.MAX_VALUE;

            // map input
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    int val = Integer.parseInt(st.nextToken());
                    map[i][j] = temp[i][j] = val;
                }
            }

            if (isPass()) {
                answer = 0;
            } else {
                injection(0, 0);
            }
            System.out.printf("#%d %d \n",tc, answer);
        }
    }

    static void injection(int cnt, int layer) {
        if (cnt >= answer) return;

        // layer가 두께와 같아졌을때 => 맨 밑 행까지 갔을때
        if (layer == D) {
            if (isPass()) {
                answer = answer > cnt ? cnt : answer;
            }
            return;
        }

        // 주입 x
        injection(cnt, layer + 1);

        // A 주입
        for (int i = 0; i < W; i++) {
            temp[layer][i] = 0;
        }
        injection(cnt+1, layer + 1);
        // B 주입
        for (int i = 0; i < W; i++) {
            temp[layer][i] = 1;
        }
        injection(cnt+1, layer + 1);
        // 원복
        for (int i = 0; i < W; i++) {
            temp[layer][i] = map[layer][i];
        }
    }

    static boolean isPass() {
        for (int i = 0; i < W; i++) {
            int cnt = 1;
            int value = temp[0][i]; // 첫번째 행부터 시작
            boolean flag = false;

            // 세로로 검증
            for (int j = 1; j < D; j++) {
                // 같은 type이라면 카운트 증가
                if (value == temp[j][i]) {
                    cnt++;
                }
                // 연속되지 않았으면 해당 type값으로 할당
                else {
                    value = temp[j][i];
                    cnt = 1;
                }

                // 연속된K를 만족할때 pass
                if (cnt == K) {
                    flag= true;
                    break;
                }
            }

            // 하나라도 검증실패시 false
            if(!flag) return false;
        }

        return true;
    }
}