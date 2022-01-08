/*
Que8: https://practice.geeksforgeeks.org/problems/count-ways-to-nth-stairorder-does-not-matter1322/1/#
*/
class Solution
{
    //Function to count number of ways to reach the nth stair 
    //when order does not matter.
    Long countWays(int n)
    {
        // n/2 -> in how many cases two occurs
        // +1 -> when there is NO 2.
        return n/2+1l;
    }    
}
