// Daily Problem 28th February

class Solution {
    public int concatenatedBinary(int n) {
        int MOD=1000000007;
        long ans=0;
        int cnt=0;
        for(int i=1;i<=n;i++)
        {
            if((i&(i-1)) == 0)
            {
                cnt++;
            }
            ans=((ans<<cnt) | i) % MOD;
        }
        return (int)ans;
    }
}