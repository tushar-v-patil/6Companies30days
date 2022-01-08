/*
Que3: https://practice.geeksforgeeks.org/problems/deee0e8cf9910e7219f663c18d6d640ea0b87f87/1/
*/
class Solution {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        
        Deque<Integer> dq = new ArrayDeque<>();
        int i = 0;
        for(i = 0; i < k; i++){
            
            while(!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]){
                dq.pollLast();
            }
            
            dq.addLast(i);
        }
        
        for(; i < n; i++){
            res.add(arr[dq.peekFirst()]);    
            
            // remove previous block indexes
            while(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }
            
            // add curr index
            while(!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]){
                dq.pollLast();
            }
            
            dq.addLast(i);
        }
        
        res.add(arr[dq.peekFirst()]);
        
        return res;
    }
}
