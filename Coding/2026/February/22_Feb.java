// Daily Problem 22nd February

class Solution {
    public int binaryGap(int n) {
        n>>=Integer.numberOfTrailingZeros(n);
        if(n==1)
        {
            return 0;
        }
        int maxi=0,gap=0;
        while(n>0)
        {
            if((n&1)==1)
            {
                maxi=Math.max(maxi,gap);
                gap=0;
            }
            else
            {
                gap++;
            }
            n/=2;
        }
        return maxi+1;
    }
}