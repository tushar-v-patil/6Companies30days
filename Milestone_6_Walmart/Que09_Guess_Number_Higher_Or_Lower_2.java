/*
Que09: https://leetcode.com/problems/guess-number-higher-or-lower-ii/
*/
class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        getMoneyAmount(1,n,dp);
        return dp[1][n];
    }
    
    private int getMoneyAmount(int start,int end,int[][] dp) {
        if(start>=end)
            return 0;
        if(dp[start][end]!=0)
            return dp[start][end];
        int minCost = Integer.MAX_VALUE;
        for(int i=start;i<=end;i++) {
            int cost=i+Math.max(getMoneyAmount(start,i-1,dp), getMoneyAmount(i+1,end,dp));
            minCost=Math.min(minCost,cost);
        }
        dp[start][end]=minCost;
        return minCost;
    }

}
