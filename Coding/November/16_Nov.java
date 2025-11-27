// Daily Problem 16th November

class Solution {
    public int numSub(String s) {
        long cnt=0, ans=0, mod=1000000007;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
            {
                cnt+=1;
            }
            else
            {
                cnt = 0;
            }
            ans=(ans+cnt)%mod;
        }
        return (int)ans;
    }
}