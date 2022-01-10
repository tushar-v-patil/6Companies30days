/*
Que10: https://practice.geeksforgeeks.org/problems/nuts-and-bolts-problem0431/1#
*/
class Solution {
    void matchPairs(char nuts[], char bolts[], int n) {
        Map<Character,int[]> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            char c = nuts[i];
            if(!map.containsKey(c)){
                map.put(c, new int[]{0,0});
            }
            int[] val = map.get(c);
            val[0]++;
            map.put(c,val);
            
            c = bolts[i];
            if(!map.containsKey(c)){
                map.put(c, new int[]{0,0});
            }
            val = map.get(c);
            val[1]++;
            map.put(c,val);
        }
        
        char[] arr = {'!', '#', '$', '%', '&', '*', '@', '^', '~'};
        int i1 = 0, i2 = 0;
        for(char c : arr){
            if(!map.containsKey(c)) continue;
            int[] val = map.get(c);
            int times = val[0];
            while(times-- > 0){
                nuts[i1++] = c;
            }
            
            times = val[1];
            while(times-- > 0){
                bolts[i2++] = c;
            }
        }
    }
}
