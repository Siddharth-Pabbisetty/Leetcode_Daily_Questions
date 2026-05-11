// Daily Problem 24th April

class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l=0,r=0,empty=0;
        for(char i:moves.toCharArray())
        {
            if(i=='L')
            {
                l++;
            }
            else if(i=='R')
            {
                r++;
            }
            else
            {
                empty++;
            }
        }
        return Math.abs(l-r)+empty;
    }
}