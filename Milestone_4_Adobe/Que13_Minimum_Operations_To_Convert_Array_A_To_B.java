/*
Que13: https://practice.geeksforgeeks.org/problems/minimum-insertions-to-make-two-arrays-equal/1/#
*/
class Solution {
    static int minInsAndDel(int[] A, int[] B, int N, int M) {
        // code here
        List<Integer> a = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int e : B){
            set.add(e);
        }
        for(int i = 0; i < N; i++){
            if(set.contains(A[i])){
                a.add(A[i]);
            }
        }
        List<Integer> lis = new ArrayList<>();
        for(int i = 0; i < a.size(); i++){
            int num = a.get(i);
            int start = 0;
            int end = lis.size()-1;
            int index = lis.size();
            while(start <= end){
                int mid = start + (end-start)/2;
                if(lis.get(mid) >= num){
                    index = mid;
                    end = mid-1;
                }
                else {
                    start = mid+1;
                }
            }
            if(index >= lis.size()){
                lis.add(num);
            }
            else {
                lis.set(index,num);
            }
        }
        return N+M-2*lis.size();
    }
}
