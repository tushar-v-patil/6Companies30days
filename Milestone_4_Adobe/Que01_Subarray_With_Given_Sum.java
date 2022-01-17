/*
Que1: https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1#
*/
class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        ArrayList<Integer> res = new ArrayList<>();
        int l = 0;
        int r = 0;
        int sum = 0;
        while(r != n){
            while(r < n && sum < s){
                sum += arr[r];
                r++;
            }
            if(sum == s){
                res.add(l+1); res.add(r);
                return res;
            }
            while(l <= r && sum > s){
                sum -= arr[l];
                l++;
            }
            if(sum == s){
                res.add(l+1); res.add(r);
                return res;
            }
        }
        res.add(-1);
        return res;
    }
}
