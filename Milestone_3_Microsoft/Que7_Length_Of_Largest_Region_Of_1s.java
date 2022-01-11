/*
Que7: https://practice.geeksforgeeks.org/problems/length-of-largest-region-of-1s-1587115620/1/#
*/
class Solution
{
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    int currAns = dfs(grid,i,j,n,m);
                    ans = Math.max(currAns,ans);
                }
            }
        }
        return ans;
    }
    
    int[] rows = {1,0,1,-1,1,-1,-1,0};
    int[] cols = {0,1,1,-1,-1,1,0,-1};
    
    public int dfs(int[][] grid, int i, int j, int n, int m){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0){
            return 0;
        }
        int ans = 1;
        grid[i][j] = 0;
        for(int x = 0; x < 8; x++){
            int nextRow = rows[x]+i;
            int nextCol = cols[x]+j;
            ans += dfs(grid,nextRow,nextCol,n,m);
        }
        return ans;
    }
}
