// Daily Problem 11th March

class Solution {
    public int bitwiseComplement(int n) {
        if(n==0)
        {
            return 1;
        }
        int cnt=n;
        for(int i=0;i<=4;i++)
        {
            cnt|=cnt>>(1<<i);
        }
        return ~n&cnt;
    }
}