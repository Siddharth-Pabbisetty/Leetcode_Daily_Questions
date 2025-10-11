// Daily Problem 1st October

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        return numBottles+(numBottles-1)/(numExchange-1);
    }
}