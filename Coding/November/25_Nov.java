// Daily Problem 25th November

class Solution {
    public int smallestRepunitDivByK(int k) {
        if((k&1)==0|| k%5==0)
            return -1;
        if(k==1)
            return 1;
        int r=1;
        for(int len=2;;len++)
        {
            r=(10*r+1)%k;
            if(r==0)
                return len;
        }
    }
}