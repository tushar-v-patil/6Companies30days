/*
Que1: https://www.google.com/url?q=https://practice.geeksforgeeks.org/problems/print-anagrams-together/1/&sa=D&source=editors&ust=1641021233423000&usg=AOvVaw0zXmUHBFQvYExA-fR31oqP
*/


class Solution {
    public List<List<String>> Anagrams(String[] arr) {
        int n = arr.length;
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            // create hash of string and put in map
            String curr = arr[i];
            int[] count = new int[26];
            for(char c : curr.toCharArray()){
                count[c-'a']++;
            }
            StringBuilder hash = new StringBuilder();
            for(int e : count){
                hash.append(e + "|");
            }
            map.computeIfAbsent(hash.toString(), x -> new ArrayList<>());
            map.get(hash.toString()).add(curr);
        }
        
        // get all the list of strings from map
        for(List<String> val : map.values()){
            res.add(new ArrayList<>(val));
        }
        
        return res;
    }
}
