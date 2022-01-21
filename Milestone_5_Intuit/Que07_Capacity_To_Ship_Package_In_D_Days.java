/*
Que07: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
*/
class Solution {
    public int shipWithinDays(int[] arr, int days) {
        int n = arr.length;
        int start = 0;
        int end = 0;
        for(int e : arr){
            end += e;
            start = Math.max(start,e);
        }
        
        int ans = end;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(good(mid,arr,days,n)){
                ans = mid;
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        return ans;
    }
    
    public boolean good(int mid, int[] arr, int days, int n){
        int sum = 0, dummyDays = 1;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            if(sum > mid){
                dummyDays++;
                sum = arr[i];
            }
        }
        return dummyDays <= days;
    }
}
