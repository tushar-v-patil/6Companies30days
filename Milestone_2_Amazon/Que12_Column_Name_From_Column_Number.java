/*
Que12: https://practice.geeksforgeeks.org/problems/column-name-from-a-given-column-number4244/1/#
*/
class Solution
{
    String colName (long n)
    {
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            n--;
            int r = (int)(n % 26);
            sb.append(((char)('A'+r))+"");
            n /= 26;
        }
        sb = sb.reverse();
        return sb.toString();
    }
}
