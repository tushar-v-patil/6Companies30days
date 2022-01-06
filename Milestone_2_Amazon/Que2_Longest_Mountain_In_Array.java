/*
Que2: https://leetcode.com/problems/longest-mountain-in-array/
*/
class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        
        int up = 0, down = 0, max = 0;
        for(int i = 1; i < n; i++){
            if(down > 0 && arr[i-1] < arr[i] || arr[i-1] == arr[i]) up = down = 0;
            if(arr[i-1] < arr[i]) up++;
            if(arr[i-1] > arr[i]) down++;
            if(up > 0 && down > 0 && up + down + 1 > max) max = up + down + 1;
        }
        
        return max;
    }
}
