/*
Que14: https://practice.geeksforgeeks.org/problems/burning-tree/1/#
*/
class Solution
{
    public static int minTime(Node root, int target) 
    {
        // find the parent of every node and the target node.
        Node targetNode = null;
        Map<Node,Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        map.put(root,null);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node curr = q.poll();
                if(curr.data == target){
                    targetNode = curr;
                }
                if(curr.left != null){
                    map.put(curr.left,curr);
                    q.add(curr.left);
                }
                if(curr.right != null){
                    map.put(curr.right,curr);
                    q.add(curr.right);
                }
            }
        }
        
        // do bfs from targetNode
        Set<Integer> visited = new HashSet<>();
        q = new LinkedList<>();
        int time = 0;
        q.add(targetNode);
        visited.add(targetNode.data);
        
        while(!q.isEmpty()){
            int size = q.size();
            time++;
            for(int i = 0; i < size; i++){
                Node curr = q.poll();
                Node par = map.get(curr);
                if(par != null && !visited.contains(par.data)){
                    visited.add(par.data);
                    q.add(par);
                }
                if(curr.left != null && !visited.contains(curr.left.data)){
                    visited.add(curr.left.data);
                    q.add(curr.left);
                }
                if(curr.right != null && !visited.contains(curr.right.data)){
                    visited.add(curr.right.data);
                    q.add(curr.right);
                }
            }
        }
        
        return time-1;
    }
}
