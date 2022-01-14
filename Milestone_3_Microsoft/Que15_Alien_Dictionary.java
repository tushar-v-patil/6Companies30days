/*
Que15: https://practice.geeksforgeeks.org/problems/alien-dictionary/1/
*/
class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < K; i++){
            list.add(new ArrayList<>());
        }
        
        int[] indegree = new int[K];
        for(int i = 0; i < N-1; i++){
            String str1 = dict[i];
            String str2 = dict[i+1];
            for(int j = 0; j < Math.min(str1.length(),str2.length()); j++){
                int ch1 = str1.charAt(j)-'a';
                int ch2 = str2.charAt(j)-'a';
                if(ch1 != ch2){
                    list.get(ch1).add(ch2);
                    indegree[ch2]++;    
                    break;
                }
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < K; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        StringBuilder res = new StringBuilder();
        while(!q.isEmpty()){
            int curr = q.poll();
            res.append((char)(curr+'a'));
            List<Integer> neighbours = list.get(curr);
            for(int e : neighbours){
                indegree[e]--;
                if(indegree[e] == 0){
                    q.add(e);
                }
            }
        }
        
        return res.toString();
    }
}
