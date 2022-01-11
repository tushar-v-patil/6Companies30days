/*
Que8: https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1/#
*/
class Solution
{
    //Function to connect nodes at same level.
    public void connect(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            Node prev = q.poll();
            if(prev.left != null){
                q.add(prev.left);
            }
            if(prev.right != null){
                q.add(prev.right);
            }
            for(int i = 0; i < size-1; i++){
                Node curr = q.poll();
                prev.nextRight = curr;
                prev = curr;
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        
    }
}
