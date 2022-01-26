/*
Que04: https://practice.geeksforgeeks.org/problems/number-of-unique-paths5339/1/#
*/
class Solution
{
    //Function to find total number of unique paths.
    public static int NumberOfPath(int n, int m) {
        int N = n+m-2;
        int C = Math.min(m-1,n-1);
        int till = N-C;
        double res = 1.0;
        for(int i = 1; i <= C; i++){
            res = res * 1.0 * N / i;
            N--;
        }
        return (int)res;
    }
}
