/*
Que12: https://leetcode.com/problems/course-schedule-ii/
*/
class Solution {
    public int[] findOrder(int n, int[][] points) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }
        
        int[] indegree = new int[n];
        for(int e[] : points){
            int x = e[0];
            int y = e[1];
            list.get(y).add(x);
            indegree[x]++;
        }
                
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        int[] ans = new int[n];
        int index = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            ans[index++] = curr;
            List<Integer> neighbours = list.get(curr);
            for(int e : neighbours){
                indegree[e]--;
                if(indegree[e] == 0){
                    q.add(e);
                }
            }
        }
        
        if(index != n) return new int[0];
        
        return ans;
    }
}
