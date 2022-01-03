/*
Que14 - https://leetcode.com/problems/minimum-size-subarray-sum/
*/
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while(j < n){
            sum += nums[j];
            if(sum >= target){
                while(i <= j && sum >= target){
                    res = Math.min(res,j-i+1);
                    sum -= nums[i];
                    i++;
                }
            }
            j++;
        }
        
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
