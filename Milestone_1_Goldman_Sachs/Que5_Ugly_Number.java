/*

Que5 - https://practice.geeksforgeeks.org/problems/ugly-numbers2254/1/#

*/

class Solution {
    /* Function to get the nth ugly number*/
    long getNthUglyNo(int n) {
        
        long[] nums = new long[n];
        long a = 2, b = 3, c = 5;
        int indexA = 0, indexB = 0, indexC = 0;
        nums[0] = 1;
        
        for(int i = 1; i < n; i++){
            long min = Math.min(a,Math.min(b,c));
            nums[i] = min;
            if(min == a){
                a = 2 * nums[++indexA];
            }
            if(min == b){
                b = 3 * nums[++indexB];
            }
            if(min == c){
                c = 5 * nums[++indexC];
            }
        }
        
        return nums[n-1];
    }
}
