/*
Que4: https://practice.geeksforgeeks.org/problems/brackets-in-matrix-chain-multiplication1024/1/#
*/
class Solution{
    static String ans = "";
    static String matrixChainOrder(int p[], int n){
        // code here
        int[][] dp = new int[n+1][n+1];
        int[][] bracket = new int[n+1][n+1];
        for(int[] e : dp) Arrays.fill(e,-1);
        helper(n,p,0,n-1,dp,bracket);
        ans = "";
        printString(0,n-1,bracket,dp);
        return ans;
    }
    
    static int helper(int N, int[] arr, int i, int j, int[][] dp, int[][] bracket){
    	if(i == j-1 || i == j) {
    	    bracket[i][j] = j;
    	    return 0;
    	}
    	if(dp[i][j] != -1) return dp[i][j];
    	int min = Integer.MAX_VALUE;
    	int brkpt = 0;
    	for(int k = i+1; k < j; k++){ 
    		int count = helper(N,arr,i,k,dp,bracket) + 
    		            helper(N,arr,k,j,dp,bracket) + 
    		            arr[i] * arr[k] * arr[j];
    		if(min >= count){
    		    min = count;
    		    brkpt = k;
    		}
    	}
    	bracket[i][j] = brkpt;
    	return dp[i][j] = min;
    }
    
    static void printString(int i, int j, int[][] bracket, int[][] dp){
        if(i > j) return;
        if(i == j-1 || i == j){
            ans += (char)('A' + j - 1);
            return;
        }
        ans += "(";
        printString(i,bracket[i][j],bracket,dp);
        printString(bracket[i][j],j,bracket,dp);
        ans += ")";
    }
}
