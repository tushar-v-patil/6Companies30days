class Solution{
    static int isValid(int board[][]){
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != 0){
                    
                    // row 
                    String row = board[i][j] + " " + i + " row";
                    if(set.contains(row)){
                        return 0;
                    }
                    set.add(row);
                    
                    // col 
                    String col = board[i][j] + " " + j + " col";
                    if(set.contains(col)){
                        return 0;
                    }
                    set.add(col);
                    
                    // box
                    String box = board[i][j] + " " + Math.floor(i/3) + " " + Math.floor(j/3) + " box";
                    if(set.contains(box)){
                        return 0;
                    }
                    set.add(box);
                    
                }
            }
        }
        return 1;
    }
    
}
