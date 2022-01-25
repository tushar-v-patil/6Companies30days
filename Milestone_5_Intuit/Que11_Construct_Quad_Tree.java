/*
Que11: https://leetcode.com/problems/construct-quad-tree/
*/
class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        return helper(grid,0,n-1,0,n-1);
    }
    
    public Node helper(int[][] grid, int r1, int r2, int c1, int c2){
        if(r1 > r2 || c1 > c2){
            return null;
        }
        
        // if leaf return it
        if(isLeafNode(grid,r1,r2,c1,c2)){
            return new Node(grid[r1][c1] == 1, true);
        }
        
        int rowMid = r1 + (r2-r1)/2;
        int colMid = c1 + (c2-c1)/2;
        
        // break the block into four parts
        // val can be true or false, since it is arbitary
        return new Node(false, false, 
                       helper(grid,r1,rowMid,c1,colMid), // top left
                       helper(grid,r1,rowMid,colMid+1,c2), // top right
                       helper(grid,rowMid+1,r2,c1,colMid), // bottom left
                       helper(grid,rowMid+1,r2,colMid+1,c2)); // bottom right
        
    }
    
    // all the vals are same then leaf otherwise not
    public boolean isLeafNode(int[][] grid, int r1, int r2, int c1, int c2){
        int val = grid[r1][c1];
        for(int i = r1; i <= r2; i++){
            for(int j = c1; j <= c2; j++){
                if(val != grid[i][j]){
                    return false;
                }   
            }
        }
        return true;
    }
}
