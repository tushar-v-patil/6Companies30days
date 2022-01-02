/*

Que-9 https://practice.geeksforgeeks.org/problems/number-following-a-pattern3126/1#
Idea: Pattern Based Question
*/

class Solution{
    static String printMinNumberForPattern(String S){
        // code here
        int n = S.length();
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i = 0; i < n; i++){
            char ch = S.charAt(i);
            if(ch == 'D'){
                stack.push(count);
                ++count;
            }
            else {
                stack.push(count);
                ++count;
                while(stack.size() > 0){
                    sb.append(stack.pop()+"");
                }
            }
        }
        stack.push(count);
        while(stack.size() > 0){
            sb.append(stack.pop()+"");
        }
        return sb.toString();
    }
}
