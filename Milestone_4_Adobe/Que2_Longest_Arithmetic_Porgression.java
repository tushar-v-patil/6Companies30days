/*
Que2: https://practice.geeksforgeeks.org/problems/longest-arithmetic-progression1019/1/#
*/
class Solution {
    int lengthOfLongestAP(int[] A, int n) {
        int max = 1;
        Map<Integer,Integer> dp[] = new HashMap[n];
        for(int i = 0; i < n; i++){
            dp[i] = new HashMap<>();
        }
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int diff = A[j]-A[i];
                int prev = Math.max(2,dp[i].getOrDefault(diff,0)+1);
                dp[j].put(diff,prev);
                max = Math.max(prev,max);
            }
        }
        return max;
    }
}
