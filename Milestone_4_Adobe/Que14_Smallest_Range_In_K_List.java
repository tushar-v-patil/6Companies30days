/*
Que14: https://practice.geeksforgeeks.org/problems/find-smallest-range-containing-elements-from-k-lists/1/
*/
class Solution
{
    static class Pair{
        int num;
        int row;
        int col;
        public Pair(int num, int row, int col){
            this.num = num;
            this.row = row;
            this.col = col;
        }
    }
	static int[] findSmallestRange(int[][] arr,int n,int k)
	{
	    PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.num-y.num);
	    int max = 0;
	    int l = -1;
	    int r = -1;
	    for(int i = 0; i < k; i++){
	        pq.add(new Pair(arr[i][0],i,0));
	        max = Math.max(max,arr[i][0]);
	    }
	    
	    while(!pq.isEmpty()){
	        Pair curr = pq.poll();
	        int min = curr.num;
	        int row = curr.row;
	        int col = curr.col;
	        if(l == -1){
	            l = min;
	            r = max;
	        }
	        else if(r-l+1 > max-min+1){
	            l = min;
	            r = max;
	        }
	        if(col+1 >= n){
	            break;
	        }
	        int next = arr[row][col+1];
	        max = Math.max(max,next);
	        pq.add(new Pair(next,row,col+1));
	    }
	    
	    return new int[]{l,r};
	}
}
