/*
Que10: https://leetcode.com/problems/number-of-provinces/
*/
class Solution {
    public int findCircleNum(int[][] graph) {
        int n = graph.length;
        DSU dsu = new DSU(n);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(graph[i][j] == 1){
                    dsu.setParent(i,j);
                }
            }
        }
        return dsu.count;
    }
    
    class DSU{
        int count;
        int[] dsu;
        public DSU(int n){
            count = n;
            dsu = new int[n];
            for(int i = 0; i < n; i++){
                dsu[i] = i;
            }
        }
        
        public int findParent(int n){
            if(dsu[n] == n) return n;
            return dsu[n] = findParent(dsu[n]);
        }
        
        public void setParent(int x, int y){
            int par1 = findParent(x);
            int par2 = findParent(y);
            if(par1 == par2) return;
            dsu[par1] = par2;
            count--;
        }
    }
}
