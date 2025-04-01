class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length;
        int[][] dp = new int[len][len];
        
        dp[0][0] = triangle[0][0];
        
        for (int r=0; r<len-1; r++) {
            for (int c=0; c<r+1; c++) {
                // #1. 현재 값과 비교
                int cur = dp[r][c];
                dp[r+1][c] = Math.max(dp[r+1][c], cur + triangle[r+1][c]);
                dp[r+1][c+1] = Math.max(dp[r+1][c+1], cur + triangle[r+1][c+1]);
            }
        }
        
        for (int c=0; c<len; c++) {
            answer = Math.max(answer, dp[len-1][c]);
        }
        
        return answer;
    }
}