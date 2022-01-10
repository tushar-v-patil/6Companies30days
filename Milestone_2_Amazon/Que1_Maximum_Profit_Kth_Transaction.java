/*
Que1: https://practice.geeksforgeeks.org/problems/maximum-profit4657/1#
*/
class Solution {
    static int maxProfit(int K, int N, int A[]) {
        // code here
        int[][] dp = new int[K+1][N];
        
        for(int i = 1; i <= K; i++){
            int max = dp[i-1][0]-A[0];
            for(int j = 1; j < N; j++){
                int profit = max + A[j];
                dp[i][j] = Math.max(dp[i][j-1],profit);
                max = Math.max(max,dp[i-1][j]-A[j]);
            }
        }
        return dp[K][N-1];
    }
    
/*
(A[j]-A[k]) + dp[i-1][k]
A[j] + dp[i-1][k] - A[k]
A[j] + (dp[i-1][k] - A[k])

dp[i][j] -> jth point with ith transaction's max profit
    10 22 5  75 65 80
0   0  0  0  0  0  0
1   0  12 12 70 60 75
2   0  12 12 82 82 87

*/
}
