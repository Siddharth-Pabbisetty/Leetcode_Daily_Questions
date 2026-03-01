// Daily Problem 18th February

class Solution {
    public boolean hasAlternatingBits(int n) {
        int val=n^(n/2);
        return (val&(val+1))==0;
    }
}