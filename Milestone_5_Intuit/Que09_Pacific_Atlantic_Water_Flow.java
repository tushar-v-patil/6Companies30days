/*
Que09: https://leetcode.com/problems/pacific-atlantic-water-flow/
*/
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] arr) {
        List<List<Integer>> res = new ArrayList<>();
        int row = arr.length;
        int col = arr[0].length;
        
        boolean[][] pac = new boolean[row][col];
        boolean[][] alt = new boolean[row][col];
        
        for(int i = 0; i < row; i++){
            dfs(i,0,row,col,pac,arr);
            dfs(i,col-1,row,col,alt,arr);
        }
        
        for(int i = 0; i < col; i++){
            dfs(0,i,row,col,pac,arr);
            dfs(row-1,i,row,col,alt,arr);
        }
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(alt[i][j] && pac[i][j]){
                    List<Integer> curr = new ArrayList<>();
                    curr.add(i); curr.add(j);
                    res.add(new ArrayList<>(curr));
                }
            }
        }
        return res;
    }
    
    public void dfs(int i, int j, int row, int col, boolean[][] vis, int[][] arr){
        if(vis[i][j]){
            return;
        }
        vis[i][j] = true;
        if(j+1 < col && arr[i][j] <= arr[i][j+1]){
            dfs(i,j+1,row,col,vis,arr);
        }
        if(j-1 >= 0 && arr[i][j] <= arr[i][j-1]){
            dfs(i,j-1,row,col,vis,arr);
        }
        if(i+1 < row && arr[i][j] <= arr[i+1][j]){
            dfs(i+1,j,row,col,vis,arr);
        }
        if(i-1 >= 0 && arr[i][j] <= arr[i-1][j]){
            dfs(i-1,j,row,col,vis,arr);
        }
    }
        
}
