import java.io.*;

/**
 *
 */
public class Main {

    static int N;
    static int[] dp, arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        arr = new int[N+1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        makeDp();

        System.out.println(dp[N]);

    }

    static void makeDp() {
        dp[1] = arr[1];

        if (N>=2){
            // 시작점인 0번을 미포함하기때문에 2부터
            dp[2] = arr[1] + arr[2];
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3]+arr[i-1]) + arr[i];
        }
    }

}