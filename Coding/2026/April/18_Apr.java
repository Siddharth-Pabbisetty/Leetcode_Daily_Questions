// Daily Problem 18th April

class Solution {
    static public int mirrorDistance(int n) {
        int r=0;
        for(int i=n;i>0;i/=10)
        {
            r=10*r+i%10;
        }
        return Math.abs(r-n);
    }
}