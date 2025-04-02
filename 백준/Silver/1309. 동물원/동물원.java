import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    
    int[][] dp = new int[N+1][3];
    
    // 경우의 수 입력
    dp[1][0] = 1; // 사자x
    dp[1][1] = 1; // 왼쪽만 
    dp[1][2] = 1; // 오른쪽만
    int mod = 9901;
    
    for (int i=2; i<=N; i++) {
        dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % mod;
        dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % mod;
        dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % mod;
    }
    
    long result = (dp[N][0] + dp[N][1] + dp[N][2]) % mod;
    System.out.println(result);
    
  }
}