/*
Que11: https://leetcode.com/problems/maximum-performance-of-a-team/
*/
class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        Integer[] ids = new Integer[n];
        for(int i = 0; i < n; i++){
            ids[i] = i;
        }

        Arrays.sort(ids, (i, j) -> efficiency[j] - efficiency[i]);

        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        long max = 0;
        long sum = 0;
        for(int i = 0; i < n; i++){

            if(heap.size() == k) {
                sum -= (long)heap.poll();
            }
            heap.add(speed[ids[i]]);
            sum += (long)speed[ids[i]];
            max = Math.max(max, efficiency[ids[i]] * sum);
        }

        return (int)(max % (long)(1e9 + 7));
    }
}
