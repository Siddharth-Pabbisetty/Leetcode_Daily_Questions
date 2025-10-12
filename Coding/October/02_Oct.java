// Daily Problem 2nd October

class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int d=numBottles;
        int e=numBottles;
        while(e>=numExchange){
            e=(e*1)-numExchange;
            numExchange++;
            d=d+1;
            e=e+1;
        }
        return d;
    }
}