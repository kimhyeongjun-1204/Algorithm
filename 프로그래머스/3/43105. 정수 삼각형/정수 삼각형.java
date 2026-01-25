import java.lang.*; 

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int r = triangle.length; 
        int c = triangle[r-1].length; // 마지막 행의 열 개수  
        
        int[][] dp = new int[r][c]; 
        
        if(r == 1) return dp[0][0]; 
        
        dp[0][0] = triangle[0][0]; 
        
        for(int i=1;i<r;i++) {
            for(int j=0;j<triangle[i].length;j++) {
                if(j > 0) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j]; 
                }
                if(j < triangle[i].length-1) {
                    dp[i][j] = Math.max(dp[i][j] , dp[i-1][j] + triangle[i][j]); 
                }
            }
        }
        
        for(int i=0;i<c;i++) {
            answer = Math.max(answer , dp[r-1][i]); 
        }
        return answer;
    }
}