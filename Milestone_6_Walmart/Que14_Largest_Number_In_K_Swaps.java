/*
Que14: https://practice.geeksforgeeks.org/problems/largest-number-in-k-swaps-1587115620/1/
*/
class Solution
{
    //Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k){
        ans = "";
        find(str.toCharArray(),k,str.length());
        return ans;
    }
    
    static String ans = "";
    public static void find(char[] arr, int k, int n){
        if(ans.equals("")){
            ans = String.valueOf(arr);
        }
        else if(ans.compareTo((String.valueOf(arr))) < 0){
            ans = String.valueOf(arr);
        }
        
        if(k == 0){
            return;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(arr[j] > arr[i]){
                    swap(i,j,arr);
                    find(arr,k-1,n);
                    swap(i,j,arr);
                }
            }
        }
    }
    
    static void swap(int i, int j, char[] arr){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
