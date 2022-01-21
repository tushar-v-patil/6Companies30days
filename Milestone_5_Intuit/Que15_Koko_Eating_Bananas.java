/*
Que15: https://leetcode.com/problems/koko-eating-bananas/
*/
class Solution {
    public int minEatingSpeed(int[] arr, int h) {
        int n = arr.length;
        int max = 0;
        for(int e : arr){
            max = Math.max(max,e);
        }
        
        int start = 1;
        int end = max;
        int ans = max;
        
        while(start <= end){
            int mid = start + (end-start)/2;
            if(good(mid,arr,n,h)){
                ans = mid;
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        return ans;
    }
    
    // can we finish all the bananas with k bananas per hour speed?
    public boolean good(int k, int[] arr, int n, int h){
        int count = 0;
        for(int i = 0; i < n; i++){
            int times = (int)Math.ceil(arr[i]*1.0/k);
            count += times;
        }
        return count <= h;
    }
}
