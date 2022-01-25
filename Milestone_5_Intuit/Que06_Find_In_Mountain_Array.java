/*
Que06: https://leetcode.com/problems/find-in-mountain-array/
*/
class Solution {
    public int findInMountainArray(int target, MountainArray arr) {
        int n = arr.length();
        Map<Integer,Integer> map = new HashMap<>();
        
        // find the peak
        int start = 0;
        int end = n-1;
        int peakIndex = 0;
        while(start <= end){
            int mid = start + (end-start)/2;
            int num1 = map.containsKey(mid) ? map.get(mid) : arr.get(mid);
            map.put(mid,num1);
            int num2 = map.containsKey(mid+1) ? map.get(mid+1) : arr.get(mid+1);
            map.put(mid+1,num2);
            
            if(num1 < num2){
                start = mid+1;
            }
            else {
                peakIndex = mid;
                end = mid-1;
            }
        }
        
        // do normal binary search to find target
        int index1 = check(0,peakIndex,arr,target,map,true);
        int index2 = check(peakIndex,n-1,arr,target,map,false);
        if(index1 == -1 && index2 == -1){
            return index1;
        }
        if(index1 != -1) return index1;
        return index2;
    }
    
    public int check(int start, int end, MountainArray arr, int target, Map<Integer,Integer> map, boolean first){
        while(start <= end){
            int mid = start + (end-start)/2;
            int num = map.containsKey(mid) ? map.get(mid) : arr.get(mid);
            map.put(mid,num);
            if(num == target){
                return mid;
            }
            if(num < target){
                if(first) start = mid+1;
                else end = mid-1;
            }
            else {
                if(first) end = mid-1;
                else start = mid+1;
            }
        }
        return -1;
    }
}
