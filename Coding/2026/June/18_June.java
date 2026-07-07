// Daily Problem 18th June

class Solution {
    public double angleClock(int hour, int minutes) {
        double val=hour+minutes/60.0;
        double diff=(11.0*val)%12.0;
        return Math.min(diff,12.0-diff)*30.0;
    }
}