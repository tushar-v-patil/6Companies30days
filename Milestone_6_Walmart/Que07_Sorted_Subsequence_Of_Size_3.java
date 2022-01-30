/*
Que07: https://practice.geeksforgeeks.org/problems/sorted-subsequence-of-size-3/1/#
*/
class Solution {
    ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] max = new int[n];
        
        for(int i = n-1; i >= 0; i--){
            if(i == n-1){
                max[i] = arr.get(i);
            }
            else {
                max[i] = Math.max(arr.get(i),max[i+1]);
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            min = Math.min(min,arr.get(i));
            if(arr.get(i) > min && arr.get(i) < max[i]){
                res.add(min);
                res.add(arr.get(i));
                res.add(max[i]);
                break;
            }
        }
        return res;
    }
}
