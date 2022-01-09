/*
Que7: https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1#
*/
class Solution
{
    public String FirstNonRepeating(String s)
    {
        int n = s.length();
        Map<Character,Integer> map = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            char currChar = '#';
            for(char c : map.keySet()){
                if(map.get(c) == 1){
                    currChar = c;
                    break;
                }
            }
            sb.append(currChar+"");
        }
        return sb.toString();
    }
}
