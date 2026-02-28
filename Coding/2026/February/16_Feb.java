// Daily Problem 16th February

public class Solution {
    public int reverseBits(int n) {
        int ans=0;
        for(int i=0;i<32;i++)
        {
            ans=ans*2;
            ans|=(n&1);
            n>>>=1;
        }
        return ans;
    }
}