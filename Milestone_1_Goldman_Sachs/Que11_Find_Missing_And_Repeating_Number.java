/*

Que-11 https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1/#

*/

class Solve {
    int[] findTwoElement(int arr[], int n) {
       int[] ans = new int[2];
       
       int xor = 0;
       for(int e : arr){
           xor ^= e;
       }
       
       for(int i = 1; i <= n; i++){
           xor ^= i;
       }
       
       // x ^ y = xor, x-> missing, y -> repeating
       
       int msb = (int)(Math.log(xor)/Math.log(2));
       
       int x = 0, y = 0;
       
       for(int i = 0; i < n; i++){
           if(((arr[i]) & (1<<msb)) != 0) {
                x ^= arr[i];
           }
           else {
               y ^= arr[i];
           }
       }
       
       for(int i = 1; i <= n; i++){
           if(((i) & (1<<msb)) != 0) {
                x ^= i;
           }
           else {
                y ^= i;
           }
       }
       
       for(int i = 0; i < n; i++){
           if(arr[i] == x){
               return new int[]{x,y};
           }
           if(arr[i] == y){
               return new int[]{y,x};
           }
       }
       
       return new int[]{-1,-1};
    }
}
