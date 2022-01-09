/*
Que11: https://practice.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1#
*/
class Tree 
{
    //Function to serialize a tree and return a list containing nodes of tree.
	public void serialize(Node root, ArrayList<Integer> A) 
	{
	    if(root == null) return ;
	    serialize(root.left,A);
	    A.add(root.data);
	    serialize(root.right,A);
	}
	
	//Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> A)
    {
        //code here
        Node newRoot = new Node(-1);
        Node temp = newRoot;
        int n = A.size();
        for(int i = 0; i < n; i++){
            temp.right = new Node(A.get(i));
            temp = temp.right;
        }
        return newRoot.right;
    }
    
}
