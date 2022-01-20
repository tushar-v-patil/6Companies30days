/*
Que03: https://practice.geeksforgeeks.org/problems/7b9d245852bd8caf8a27d6d3961429f0a2b245f1/1/#
*/
class Solution{
    public int kvowelwords(int n,int k){
        int mod = 1000000007;
        long[][] dp = new long[n+1][k+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= k; j++){
                if(i == 0){
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = (dp[i-1][k]%mod * 21%mod) % mod;
                    if(j > 0){
                        dp[i][j] = (dp[i][j]%mod + (dp[i-1][j-1]%mod * 5%mod)%mod)%mod;
                    }
                }
            }
        }
        return (int)dp[n][k];
        
    }
}
