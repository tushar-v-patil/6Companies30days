/*
Que12: https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1/#
*/
class Solution{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        ArrayList<Integer> al = new ArrayList<>();
        int curr = arr[n-1];
        al.add(curr);
        for(int i = n-2; i >= 0; i--){
            if(arr[i] >= curr){
                curr = arr[i];
                al.add(arr[i]);
            }
        }
        Collections.reverse(al);
        return al;
    }
}
