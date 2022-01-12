/*
Que11: https://practice.geeksforgeeks.org/problems/generate-binary-numbers-1587115620/1
*/
class solve{
    
    //Function to generate binary numbers from 1 to N using a queue.
    static ArrayList<String> generate(int N)
    {
        ArrayList<String> res = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            res.add(toBinary(i));
        }
        return res;
    }
    
    static String toBinary(int num){
        StringBuilder sb = new StringBuilder();
        int size = (int)(Math.log(num)/Math.log(2));
        for(int i = 0; i <= size; i++){
            if(((num&(1<<i)) != 0)){
                sb.append("1");
            }
            else {
                sb.append("0");
            }
        }
        sb = sb.reverse();
        return sb.toString();
    }
}
