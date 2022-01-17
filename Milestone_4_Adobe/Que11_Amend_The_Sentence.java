/*
Que11: https://practice.geeksforgeeks.org/problems/amend-the-sentence3235/1#
*/
class Solution{
    public String amendSentence(String s){
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int l = 0;
        int r = 1;
        char ch = s.charAt(l);
        sb.append((ch+"").toLowerCase());
        while(r < n){
            ch = s.charAt(r);
            if(Character.isUpperCase(ch)){
                sb.append(" " + (ch+"").toLowerCase());
                l = r;
                r++;
            }
            else {
                sb.append(ch);
                r++;
            }
        }
        return sb.toString();
    }
}
