/*
Que14: https://leetcode.com/problems/as-far-from-land-as-possible/
*/
class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        return bfs(grid,n,new int[n][n], new boolean[n][n]);
    }
    
    int[] rows = {1,0,-1,0};
    int[] cols = {0,1,0,-1};
    
    int bfs(int[][] grid, int n, int[][] dp, boolean[][] vis){
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    q.add(new int[]{i,j,0});
                    vis[i][j] = true;
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int d = curr[2];
            
            for(int i = 0; i < 4; i++){
                int row = x + rows[i];
                int col = y + cols[i];
                if(row >= n || row < 0 || col >= n || col < 0 || vis[row][col] || grid[row][col] == 1){
                    continue;
                }
                vis[row][col] = true;
                dp[row][col] = d+1;
                q.add(new int[]{row,col,d+1});
            }
        }
        
        int max = -1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) max = Math.max(max,dp[i][j]);
            }
        }
        return max == 0 ? -1 : max;
    }
}
