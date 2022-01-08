/*
Que5: https://practice.geeksforgeeks.org/problems/phone-directory4628/1/#
*/
class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s)
    {
        HashSet<String> set = new HashSet<>();
        for(String cont : contact){
            set.add(cont);
        }
        
        contact = new String[set.size()];
        int index = 0;
        for(String str : set){
            contact[index++] = str;
        }
        
        Arrays.sort(contact);
        
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            list.add(new ArrayList<>());
        }
        
        for(String cont : contact){
            for(int i = 0; i < cont.length(); i++){
                if(i < s.length() && cont.charAt(i) == s.charAt(i)){
                    list.get(i).add(cont);
                }
                else {
                    break;
                }
            }
        }
        
        for(int i = 0; i < s.length(); i++){
            if(list.get(i).size() == 0){
                list.get(i).add("0");
            }
        }
        
        return list;
    }
}
