/*
Que5: https://practice.geeksforgeeks.org/problems/express-as-sum-of-power-of-natural-numbers5647/1#
*/
/class Solution
{
    static int numOfWays(int n, int x)
    {
        long[][] dp = new long[1001][1001];
        for(long[] e : dp) Arrays.fill(e,-1);
        return (int)helper(n*1l,x*1l,1l,0,dp);
    }
    
    static long helper(long n, long x, long num, long curr, long[][] dp){
        if(curr > n || num > 1000){
            return 0;
        }
        if(curr == n){
            return 1;
        }
        if(dp[(int)num][(int)curr] != -1){
            return dp[(int)num][(int)curr];
        }
        long withPow = helper(n,x,num+1,curr+power(num,x),dp);
        long withOutPow = helper(n,x,num+1,curr,dp);
        return dp[(int)num][(int)curr] = withPow + withOutPow;
    }
    
    public static long power(long x, long y)
    {
        long res = 1L;
        x = x;
        while(y > 0)
        {
            if((y&1)==1)
                res = (res*x);
            y >>= 1;
            x = (x*x);
        }
        return res;
    } 
}
