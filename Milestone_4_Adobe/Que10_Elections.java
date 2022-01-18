/*
Que10: https://practice.geeksforgeeks.org/problems/winner-of-an-election-where-votes-are-represented-as-candidate-names-1587115621/1/
*/
class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // add your code
        Map<String,Integer> map = new HashMap<>();
        int max = 0;
        for(String s : arr){
            map.put(s,map.getOrDefault(s,0)+1);
            max = Math.max(max,map.get(s));
        }
        
        String ans = "";
        for(String s : map.keySet()){
            if(map.get(s) == max){
                if(ans.equals("")){
                    ans = s;
                }
                else if(ans.compareTo(s) > 0){
                    ans = s;
                }
            }
        }
        return new String[]{ans,max+""};
    }
}
