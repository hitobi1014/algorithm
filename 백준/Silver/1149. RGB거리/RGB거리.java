import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * RGB거리
 */
public class Main {
    static int N, answer;
    static int[][] homes;
    static int[][] dp;
    static final int Red = 0;
    static final int Green = 1;
    static final int Blue = 2;

    public static void main(String[] args) throws Exception{

        // 총 R G B 3번의 for문을 도는데
        // 처음 고른 RGB와 다른 색 중 최솟값을 고르고
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        homes = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            homes[i][Red] = Integer.parseInt(st.nextToken());
            homes[i][Green] = Integer.parseInt(st.nextToken());
            homes[i][Blue] = Integer.parseInt(st.nextToken());
        }

        dp[0][Red] = homes[0][Red];
        dp[0][Green] = homes[0][Green];
        dp[0][Blue] = homes[0][Blue];

        answer = Math.min(find(N - 1, Red), Math.min(find(N - 1, Green), find(N - 1, Blue)));
        System.out.println(answer);
    }

    private static int find(int N, int rgb){

        if (dp[N][rgb] == 0) {
            if (rgb == Red) {
                dp[N][Red] = Math.min(find(N - 1, Green), find(N - 1, Blue)) + homes[N][Red];
            } else if (rgb == Green) {
                dp[N][Green] = Math.min(find(N - 1, Red), find(N - 1, Blue)) + homes[N][Green];
            } else {
                dp[N][Blue] = Math.min(find(N - 1, Green), find(N - 1, Red)) + homes[N][Blue];
            }
        }

        return dp[N][rgb];
    }
}