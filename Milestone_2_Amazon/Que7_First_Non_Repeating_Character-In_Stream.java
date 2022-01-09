/*
Que7: https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1#
*/

// Solution 1: In java use linked hashmap
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

// Solution 2 : Using sliding window
class Solution
{
    public String FirstNonRepeating(String s)
    {
        int n = s.length();
        Deque<Integer> dq = new ArrayDeque<>();
        int[] hash = new int[26];
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            
            if(hash[ch-'a'] == 0){
                dq.addLast(ch-'a');
            }
            
            hash[ch-'a']++;
            
            while(!dq.isEmpty() && hash[dq.peekFirst()] != 1){
                dq.pollFirst();
            }
            
            if(dq.isEmpty()) sb.append("#");
            else sb.append((char)('a' + dq.peekFirst()));
        }
        return sb.toString();
    }
}
