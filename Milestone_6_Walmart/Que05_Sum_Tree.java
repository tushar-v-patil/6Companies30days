/*
Que05: https://practice.geeksforgeeks.org/problems/transform-to-sum-tree/1/#
*/
class Solution{
    public void toSumTree(Node root){
        helper(root);
    }
    
    public int helper(Node root){
        if(root == null){
             return 0;
         }
         int temp = root.data;
         int left = helper(root.left);
         int right = helper(root.right);
         root.data = left + right;
         return temp+root.data;
    }
}
