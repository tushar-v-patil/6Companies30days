/*
Que08: https://leetcode.com/problems/number-of-boomerangs/
*/
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int boomerangs = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int n = points.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                int x = (points[i][0]-points[j][0]);
                int y = (points[i][1]-points[j][1]);
                int dist = x*x + y*y;
                map.put(dist,map.getOrDefault(dist,0)+1);
            }
            for(int val : map.values()){
                boomerangs += val * (val-1);
            }
            map.clear();
        }
        return boomerangs;
    }
}
