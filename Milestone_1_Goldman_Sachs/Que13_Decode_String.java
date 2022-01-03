/*

Que-13 https://practice.geeksforgeeks.org/problems/decode-the-string2444/1

*/
class Solution{
    static String decodedString(String s){
        int n = s.length();
        Stack<String> stack = new Stack<>();
        int i = 0;
        while(i < n){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                while(i < n && Character.isDigit(s.charAt(i))){
                    stack.add(s.charAt(i)+"");
                    i++;
                }
                stack.add(s.charAt(i)+"");
                i++;
            }
            else if(Character.isAlphabetic(s.charAt(i))){
                stack.add(s.charAt(i)+"");
                i++;
            }
            else if(s.charAt(i) == '['){
                stack.add(s.charAt(i)+"");
                i++;
            }
            else if(s.charAt(i) == ']'){
                String ans = "";
                while(!stack.isEmpty() && !stack.peek().equals("[")){
                    ans = stack.pop() + "" + ans;
                }
                stack.pop();
                String num = "";
                while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))){
                    num = stack.pop() + "" + num;
                }
                int nums = Integer.parseInt(num);
                String push = "";
                for(int x = 0; x < nums; x++){
                    push += ans;
                }
                stack.add(push);
                i++;
            }
        }
        String res = "";
        while(!stack.isEmpty()){
            res = stack.pop() + "" + res;
        }
        return res;
    }
}
