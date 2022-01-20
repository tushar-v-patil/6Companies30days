/*
Que8: https://practice.geeksforgeeks.org/problems/implement-atoi/1/
*/
class Solution
{
    int atoi(String str) {
	// Your code here
	    int num = 0;
	    int n = str.length();
	    // check for spaces
	    int i = 0;
	    while(i < n && str.charAt(i) == ' '){
	        i++;
	    }
	    
	    // check for negative
	    int mul = 1;
	    if(i < n && str.charAt(i) == '-'){
	        mul = -1;
	        i++;
	    }
	    else if(i < n && str.charAt(i) == '+'){
	        i++;
	    }
	    
	    // add the nums
	    while(i < n){
	        char ch = str.charAt(i);
	        if(!Character.isDigit(ch)){
	            return -1;
	        }
	        int digit = ch-'0';
	        // num * 10 + numChar < Integer.MAX_VALUE
	        if((Integer.MAX_VALUE-digit)/10 < num){
	            return mul == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
	        }
	        num = num*10 + digit;
	        i++;
	    }
	    return mul == -1 ? -num : num;
    }
}
