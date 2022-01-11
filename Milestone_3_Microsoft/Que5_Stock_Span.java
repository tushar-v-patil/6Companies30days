/*
Que5: https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1#
*/
class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        int[] ans = new int[n];
        // previous greater element
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && price[stack.peek()] <= price[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = i+1;
            }
            else {
                ans[i] = i-stack.peek();
            }
            stack.add(i);
        }
        return ans;
    }
    
}
