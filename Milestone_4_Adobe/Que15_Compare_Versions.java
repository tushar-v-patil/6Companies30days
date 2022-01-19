/*
Que15: Similar to https://leetcode.com/problems/compare-version-numbers/
*/
class Solution {
    
    public String recentVersion(String v1, String v2){
        int ans = compareVersion(v1,v2);
        if(ans == -1){
            return v2;
        }
        else {
            return v1;
        }
    }
    
    public int compareVersion(String v1, String v2) {
        int n = v1.length();
        int m = v2.length();
        int i = 0;
        int j = 0;
        
        while(i < n || j < m){
            int num1 = 0;
            int num2 = 0;
            
            while(i < n && v1.charAt(i) != '.'){
                num1 = num1 * 10 + (v1.charAt(i)-'0');    
                i++;
            }
            
            while(j < m && v2.charAt(j) != '.'){
                num2 = num2 * 10 + (v2.charAt(j)-'0');
                j++;
            }
            
            if(num1 < num2) return -1;
            if(num1 > num2) return 1;
            
            i++;
            j++;
        }
        return 0;
    }
}
