/*
Que07: https://practice.geeksforgeeks.org/problems/pots-of-gold-game/1/#
*/
class GfG
{
	public static int maxCoins(int A[],int n)
	{
	    int[][] dp = new int[n][n];
	    for(int[] e : dp) Arrays.fill(e,-1);
        return helper(A,n,0,n-1,dp);
    }
    
    public static int helper(int[] A, int n, int start, int end, int[][] dp){
        if(start > end){
            return 0;
        }
        
        if(start == end){
            return dp[start][end] = A[start];
        }
        
        if(dp[start][end] != -1){
            return dp[start][end];
        }
        
        // X will pick start
        int op1 = A[start] + Math.min(helper(A,n,start+2,end,dp),helper(A,n,start+1,end-1,dp));
        
        // X will pick end
        int op2 = A[end] + Math.min(helper(A,n,start+1,end-1,dp),helper(A,n,start,end-2,dp));
        
        // we need max in worst case for X
        return dp[start][end] = Math.max(op1,op2);
    }
}
