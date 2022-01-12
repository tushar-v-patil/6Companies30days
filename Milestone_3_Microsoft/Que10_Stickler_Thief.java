/*
Que10: https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1
*/
class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = Math.max(arr[i]+(i-2 < 0 ? 0 : dp[i-2]),(i-1 < 0 ? 0 : dp[i-1]));
        }
        return dp[n-1];
    }
}
