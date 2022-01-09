/*
Que6: https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1#
*/
class Solution
{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
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
