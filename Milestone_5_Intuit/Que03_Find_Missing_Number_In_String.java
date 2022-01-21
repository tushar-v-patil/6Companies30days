/*
Que03: https://practice.geeksforgeeks.org/problems/find-the-missing-no-in-string/1/#
*/
class GfG
{
	public int missingNumber(String s){
        int n = s.length();
        ot: for(int i = 0; i < Math.min(n,6); i++)   {
            int count = 0;
            int ans = -1;
            String numStr = s.substring(0,i+1);
            int num = Integer.parseInt(numStr);
            boolean is = true;
            int j = i+1;
            while(j < n){
                boolean op1 = isValue(s,j,1,num,n);
                if(op1){
                    j += ((num+1)+"").length();
                    num = num+1;
                    continue;
                }
                boolean op2 = isValue(s,j,2,num,n);
                if(op2){
                    count++;
                    ans = num+1;
                    j += ((num+2)+"").length();
                    num = num+2;
                    continue;
                }
                continue ot;
            }
            if(count == 1) return ans;
        }
        return -1;
    }
    
    boolean isValue(String s, int j, int add, int num, int n){
        int next = num+add;
        String strNext = next+"";
        if(j+strNext.length() > n){
            return false;
        }
        String currNext = s.substring(j,j+strNext.length());
        int currNextNum = Integer.parseInt(currNext);
        if(currNextNum == next){
            return true;
        }
        return false;
    }
    
}
