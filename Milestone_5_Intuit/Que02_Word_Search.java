/*
Que02: https://practice.geeksforgeeks.org/problems/word-search/1/#
*/
class Solution
{
    public boolean isWordExist(char[][] board, String word)
    {
        if(word.length() == 0) return false;
        int row = board.length;
        int col = board[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == word.charAt(0) && 
                    helper(board,word,0,row,col,new boolean[row][col],i,j)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean helper(char[][] board, String word, int index, int row, int col, 
                            boolean[][] vis, int i, int j){
        if(index >= word.length()){
            return true;
        }        
        if(i < 0 || i >= row || j < 0 || j >= col || vis[i][j]){
            return false;
        }
        
        if(word.charAt(index) == board[i][j]){
            vis[i][j] = true;
            boolean op1 = helper(board,word,index+1,row,col,vis,i+1,j);
            boolean op2 = helper(board,word,index+1,row,col,vis,i-1,j);
            boolean op3 = helper(board,word,index+1,row,col,vis,i,j+1);
            boolean op4 = helper(board,word,index+1,row,col,vis,i,j-1);
            vis[i][j] = false;
            return op1 || op2 || op3 || op4;    
        }
        return false;
    }
}
