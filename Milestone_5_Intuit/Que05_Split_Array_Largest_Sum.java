/*
Que05: https://leetcode.com/problems/split-array-largest-sum/
*/
class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int start = 0;
        int end = 0;
        for(int i = 0; i < n; i++){
            end += nums[i];
        }
        
        int ans = end;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(good(mid,nums,n,m)){
                ans = mid;
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        return ans;
    }
    
    public boolean good(int sum, int[] nums, int n, int m){
        int currSum = 0;
        int splits = 1;
        for(int i = 0; i < n; i++){
            if(nums[i] > sum) return false;
            currSum += nums[i];
            if(currSum > sum){
                currSum = nums[i];
                splits++;
            }
        }
        return splits <= m;
    }
}
