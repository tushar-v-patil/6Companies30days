    /*
    
    Que-3 - https://practice.geeksforgeeks.org/problems/count-the-subarrays-having-product-less-than-k1708/1/#
    
    */
    
    public int countSubArrayProductLessThanK(long a[], long len, long k)
    {
        int n = (int)len;
        int res = 0;
        int i = 0;
        int j = 0;
        long mul = 1l;
        while(i < n){
            mul *= a[i];
            while(j < n && mul >= k){
                mul /= a[j];
                j++;
            }
            res += (i-j+1);
            i++;
        }
        
        return res;
    }
