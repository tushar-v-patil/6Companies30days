/*
Que03: https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/
*/
class Solution {
    public boolean winnerOfGame(String s) {
        int a = 0;
        int b = 0;
        int n = s.length();
        for(int i = 1; i < n-1; i++){
            if(s.charAt(i) == 'A' && s.charAt(i+1) == 'A' && s.charAt(i-1) == 'A'){
                a++;
            }
            if(s.charAt(i) == 'B' && s.charAt(i+1) == 'B' && s.charAt(i-1) == 'B'){
                b++;
            }
        }
        
        if(a > b) return true;
        return false;
    }
}
