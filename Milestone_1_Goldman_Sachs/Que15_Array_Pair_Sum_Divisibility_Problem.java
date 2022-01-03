/*
Que15- https://practice.geeksforgeeks.org/problems/array-pair-sum-divisibility-problem3257/1#
*/
class Solution {
    public boolean canPair(int[] nums, int k) {
        int n = nums.length;
        int[] count = new int[k];
        
        for(int i = 0; i < n; i++){
            count[nums[i]%k]++;
        }
        
        if(count[0] % 2 != 0){
            return false;
        }
        
        for(int i = 1; i < k; i++){
            if(i == k-i){
                if(count[i] % 2 != 0){
                    return false;
                }
            }
            else if(count[i] != count[k-i]){
                return false;
            }
        }
        return true;
    }
}
