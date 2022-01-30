/*
Que02: https://leetcode.com/problems/stone-game/
*/
class Solution {
    public boolean stoneGame(int[] piles) {
        int low=0,high=piles.length-1;
        int alice=0, bob=0;
        while(low<high)
        {
            alice+=Math.max(piles[low],piles[high]);
            bob+=Math.min(piles[low],piles[high]);
            low++;
            high--;
        }
        return alice > bob;
    }
}
