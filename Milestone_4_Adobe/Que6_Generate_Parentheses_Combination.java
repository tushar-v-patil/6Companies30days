/*
Que6: https://practice.geeksforgeeks.org/problems/generate-all-possible-parentheses/1/#
*/
class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
        List<String> list = new ArrayList<>();
        helper(n,"",0,0,list);
        return list;
    }
    
    public void helper(int n, String curr, int opening, int closing, List<String> list){
        if(curr.length() == 2*n){
            list.add(curr);
            return;
        }
        if(opening < n) helper(n,curr+"(",opening+1,closing,list);
        if(opening > closing) helper(n,curr+")",opening,closing+1,list);
    }
}
