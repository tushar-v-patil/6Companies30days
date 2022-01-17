/*
Que4: https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1#
*/
class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum = 0;
        for(int e : arr) sum += e;
        if(sum % 2 == 1) return 0;
        int[][] dp = new int[N][sum/2];
        for(int[] e : dp) Arrays.fill(e,-1);
        return helper(N,arr,sum/2,0,0,dp) ? 1 : 0;
    }
    
    static boolean helper(int N, int[] arr, int sum, int currSum, int index, int[][] dp){
        if(currSum == sum){
            return true;
        }
        if(index >= N || currSum > sum){
            return false;
        }
        if(dp[index][currSum] != -1){
            return dp[index][currSum] == 1 ? true : false;
        }
        boolean op1 = helper(N,arr,sum,currSum+arr[index],index+1,dp);
        boolean op2 = helper(N,arr,sum,currSum,index+1,dp);
        dp[index][currSum] = (op1 || op2) ? 1 : 2;
        return op1 || op2;
    }
}
