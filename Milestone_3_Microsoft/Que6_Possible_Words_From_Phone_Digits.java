/*
Que6: https://practice.geeksforgeeks.org/problems/possible-words-from-phone-digits-1587115620/1/#
*/
class Solution
{
    //Function to find list of all words possible by pressing given numbers.<>();
    static ArrayList<String> possibleWords(int a[], int N)
    {
        ArrayList<String> list = new ArrayList<>();
        if(N == 0){
            return list;
        }
        String keypad[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        helper(a,N,0,"",list,keypad);
        return list;
    }
    
    static void helper(int[] a, int N, int index, String curr, List<String> list, 
                        String[] keypad){
        if(index >= N){
            list.add(curr);
            return;
        }
        String input = keypad[a[index]];
        int len = input.length();
        for(int i = 0; i < len; i++){
            char ch = input.charAt(i);
            helper(a,N,index+1,curr+ch,list,keypad);
        }
    }
}
