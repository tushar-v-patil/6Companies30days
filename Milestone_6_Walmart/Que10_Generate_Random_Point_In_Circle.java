/*
Que10: https://leetcode.com/problems/generate-random-point-in-a-circle/
*/
class Solution {

    private double x, y, r;
    private ThreadLocalRandom rand;
    
    public Solution(double radius, double x_center, double y_center) {
        x = x_center;
        y = y_center;
        r = radius;
        rand = ThreadLocalRandom.current();
    }
    
    public double[] randPoint() {
        double minx = x - r;
        double maxx = x + r;
        double miny = y - r;
        double maxy = y + r;
        do {
            double xx = rand.nextDouble(minx, maxx);
            double yy = rand.nextDouble(miny, maxy);
            if (inCircle(xx, yy)) {
                return new double[]{xx, yy};
            }
        } while(true);
    }
    
    boolean inCircle(double xx, double yy) {
        xx -= x;
        yy -= y;
        xx = xx * xx;
        yy = yy * yy;
        return xx + yy <= r * r;
    }
}
