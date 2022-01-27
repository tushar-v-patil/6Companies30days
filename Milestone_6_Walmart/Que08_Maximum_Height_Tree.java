/*
Que08: https://practice.geeksforgeeks.org/problems/maximum-height-tree4803/1/?page=2&company[]=Walmart&query=page2company[]Walmart#
*/
class Solution{
    static int height(int N){
        int i = 1;
        int res = 1;
        while(res <= N){
            res += i+1;
            i++;
        }
        return i-1;
    }
}
