/*
Que06: https://practice.geeksforgeeks.org/problems/power-of-numbers-1587115620/1/?company[]=Walmart&company[]=Walmart&page=1&query=company[]Walmartpage1company[]Walmart#
*/
class Solution
{
    
    long power(int N,int R)
    {
        long mod = 1000000007;
        return power(N,R,mod);
    }
    
    long power(long x, long y, long p) {
      long res = 1L;
      x = x % p;
      while (y > 0) {
        if ((y & 1) == 1)
          res = (res * x) % p;
        y >>= 1;
        x = (x * x) % p;
      }
      return res;
    }

}
