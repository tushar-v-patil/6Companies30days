/*
Que13; https://leetcode.com/problems/rotting-oranges/
*/

class Solution { 
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[] rows = {1,0,-1,0};
        int[] cols = {0,1,0,-1};
        
        Queue<int[]> q = new LinkedList<>();
        int fruit = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j,0});
                }
                if(grid[i][j] == 2 || grid[i][j] == 1){
                    fruit++;
                }
            }
        }
        
        int max = 0;
        while(!q.isEmpty()){
            int curr[] = q.poll();
            int r = curr[0], c = curr[1], t = curr[2];
            max = Math.max(t,max);
            fruit--;
            for(int i = 0; i < 4; i++){
                int nextR = r + rows[i];
                int nextC = c + cols[i];
                if(nextR < n && nextR >= 0 && nextC < m && nextC >= 0 && grid[nextR][nextC] == 1){
                    grid[nextR][nextC] = 2;
                    q.add(new int[]{nextR, nextC, t + 1});
                }
            }
        }
        
        return fruit != 0 ? -1 : max;
    }
}
