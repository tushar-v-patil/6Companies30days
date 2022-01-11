/*
Que12: https://practice.geeksforgeeks.org/problems/find-all-four-sum-numbers1732/1#
*/
class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);
        for(int i = 0; i < n; i++){
            if(i > 0 && arr[i] == arr[i-1]) continue;
            for(int j = i+1; j < n; j++){
                if(j > i+1 && arr[j] == arr[j-1]) continue;
                int sum = arr[i] + arr[j];
                int left = j+1;
                int right = n-1;
                while(left < right){
                    int currSum = arr[left] + arr[right];
                    if(sum + currSum == k){
                        ArrayList<Integer> curr = new ArrayList<>();
                        curr.add(arr[i]);
                        curr.add(arr[j]);
                        curr.add(arr[left]);
                        curr.add(arr[right]);
                        res.add(new ArrayList<>(curr));
                        left++;
                        while(left < right && arr[left] == arr[left-1]){
                            left++;
                        }
                        right--;
                        while(left < right && arr[right] == arr[right+1]){
                            right--;
                        }
                    }
                    else if(sum + currSum > k){
                        right--;
                    }
                    else {
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
