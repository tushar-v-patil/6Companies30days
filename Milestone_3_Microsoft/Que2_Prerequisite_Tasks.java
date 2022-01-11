/*
Que2: https://practice.geeksforgeeks.org/problems/prerequisite-tasks/1/
*/
class Solution {
    public boolean isPossible(int N, int[][] arr)
    {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            list.add(new ArrayList<>());
        }
        int[] indegree = new int[N];
        for(int[] e : arr){
            int node1 = e[0];
            int node2 = e[1];
            list.get(node2).add(node1);
            indegree[node1]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        int count = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            count++;
            List<Integer> neighbours = list.get(curr);
            for(int e : neighbours){
                indegree[e]--;
                if(indegree[e] == 0){
                    q.add(e);
                }
            }
        }
        
        return count == N;
    }
}
