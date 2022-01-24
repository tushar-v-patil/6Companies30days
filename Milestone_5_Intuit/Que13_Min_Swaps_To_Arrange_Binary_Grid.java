/*
Que13: https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/
*/
class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int count = 0;
        
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)  {
            int zeros = find(grid,n,i);
            arr[i] = zeros;
        }
        
        for(int i = 0; i < n; i++){
            int need = n-i-1;
            if(need <= arr[i]){
                continue;
            }
            
            int index = -1;
            for(int j = i+1; j < n; j++){
                if(need <= arr[j]){
                    index = j;
                    break;
                }
            }
            
            if(index == -1) return -1;
            count += index-i;
            
            int temp = arr[i];
            for(int j = i+1; j <= index; j++){
                int curr = arr[j];
                arr[j] = temp;
                temp = curr;
            }
            arr[i] = temp;
        }
        
        return count;
    }
    
    public int find(int[][] grid, int n, int row){
        int tempZ = 0;
        for(int j = n-1; j >= 0; j--){
            if(grid[row][j] == 0){
                tempZ++;
            }
            else {
                break;
            }
        }
        return tempZ;
    }
}
