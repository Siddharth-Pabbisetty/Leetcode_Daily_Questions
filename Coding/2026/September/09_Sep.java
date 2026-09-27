// Daily Problem 9th September

class Solution {
    public long countCommas(long n) {
        long cnt=0;
        for(long i=1000;i<=n;i*=1000)
        {
            cnt+=n-i+1;
        }
        return cnt;
    }
}