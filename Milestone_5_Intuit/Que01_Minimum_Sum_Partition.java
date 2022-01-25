/*
Que01: https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1/#
*/
class Solution
{
	public int minDifference(int arr[], int n) 
	{ 
	    int sum = 0;
	    for(int e : arr) sum += e;
	    return minDiff(arr,n,0,sum,0);
	}
	
	Map<String,Integer> map = new HashMap<>();
	public int minDiff(int[] arr, int n, int index, int sum, int currSum){
	    String hash = index + "|" + currSum;
	    
	    if(index == n){
	        int min = Math.abs((sum-currSum)-currSum);    
	        return min;
	    }
	    
	    if(map.containsKey(hash)){
	        return map.get(hash);
	    }
	    
	    // pick
	    int op1 = minDiff(arr,n,index+1,sum,currSum+arr[index]);
	    // not pick
	    int op2 = minDiff(arr,n,index+1,sum,currSum);
	    
	    int min = Math.min(op1,op2);
	    map.put(hash,min);
	    
	    return min;
	}
    
}
