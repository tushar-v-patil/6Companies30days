/*
Que9: https://practice.geeksforgeeks.org/problems/count-number-of-subtrees-having-given-sum/1/#
*/
class Tree
{
    //Function to count number of subtrees having sum equal to given sum.
    class Count{
        int count = 0;
    }
    
    int countSubtreesWithSumX(Node root, int X)
    {
        Count count = new Count();
	    helper(root,X,count);
	    return count.count;
    }
    
    int helper(Node root, int X, Count count){
        if(root == null) return 0;
        int left = helper(root.left,X,count);
        int right = helper(root.right,X,count);
        int tot = root.data + left + right;
        if(tot == X){
            count.count++;
        }
        return tot;
    }
}
