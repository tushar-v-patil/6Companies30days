/*
Que13: https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/
*/
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums,
            Comparator.comparing(String::length).thenComparing(Function.identity()));
        int n = nums.length;
        for(int i = n-1; i >= 0; i--){
            k--;
            if(k == 0){
                return nums[i];
            }
        }
        return "-1";
    }
}
