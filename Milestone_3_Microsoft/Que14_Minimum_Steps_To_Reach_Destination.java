/*
Que14: https://practice.geeksforgeeks.org/problems/minimum-number-of-steps-to-reach-a-given-number5234/1/#
*/
class Solution{
    static int minSteps(int n){
        // code here
        n = Math.abs(n);
        int steps = 0;
        int sum = 0;
        
        while(sum < n){
            steps++;
            sum += steps;
        }
        
        while((sum-n) % 2 == 1){
            steps++;
            sum += steps;
        }
        
        return steps;
    }
}
