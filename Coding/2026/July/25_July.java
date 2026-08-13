// Daily Problem 25th July

class Solution {
    public int maxProduct(int n) {
        int maxi1=0,maxi2=0;
        for(;n!=0;n/=10)
        {
            int val=n%10;
            if(val>=maxi1)
            {
                maxi2=maxi1;
                maxi1=val;
            }
            else if(val>maxi2)
                maxi2=val;
        }
        return maxi1*maxi2;
    }
}