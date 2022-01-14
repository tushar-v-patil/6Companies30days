/*
Que13: https://practice.geeksforgeeks.org/problems/bridge-edge-in-graph/1#
*/
class Solution
{
    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int n, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	
    	int[] tim = new int[n+1];
    	int[] low = new int[n+1];
    	
    	Queue<Integer> q = new LinkedList<>();
    	boolean[] vis = new boolean[n+1];
    	int indegree[] = new int[n+1];
    	for(int i = 1; i <= n; i++){
    	    ArrayList<Integer> neighbours = adj.get(i);
    	    for(int e : neighbours){
    	        indegree[e]++;
    	    }
    	}
    	
    	for(int i = 1; i <= n; i++){
    	    if(indegree[i] == 1 || indegree[i] == 0){
    	        q.add(i);
    	    }
    	}
    	
    	while(!q.isEmpty()){
    	    int curr = q.poll();
    	    if(!vis[curr]){
    	        dfs(adj,res,tim,low,n,curr,-1,vis,0);        
    	    }   
    	}
    	
    	
    	for(List<Integer> l : res){    
    	    int x = l.get(0);
    	    int y = l.get(1);
    	    if((x == c && y == d) || (x == d && y == c)){
    	        return 1;
    	    }
    	}
    	return 0;
    }
    
    static void dfs(ArrayList<ArrayList<Integer>> list, ArrayList<ArrayList<Integer>> res, int[] time, int[] low, int n, int curr, int par, boolean[] vis, int timer){
    	
    	vis[curr] = true;
    	time[curr] = low[curr] = timer++;
    	
    	ArrayList<Integer> neighbours = list.get(curr);
    	
    	for(int e : neighbours){
    		if(e == par) continue;
    		
    		if(vis[e]){ // we are visting the ancestor - back edge
    			low[curr] = Math.min(low[curr],time[e]);
    		}
    		else { // forward edge
    			dfs(list,res,time,low,n,e,curr,vis,timer);
    			low[curr] = Math.min(low[curr],low[e]);
    			if(low[e] > time[curr]){ // means the neighbour node doesn't have any connection with curr's ancestor
    				List<Integer> l = new ArrayList<>();
    				l.add(curr);
    				l.add(e);
    				res.add(new ArrayList<>(l));
    			}
    		}
    	}
    }

}
