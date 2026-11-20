// Daily Problem 18th November

class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n=bits.length;
        int cnt=0;
        while(cnt<n-1)
        {
            cnt+=bits[i]+1;
        }
        return cnt==n-1;
    }
}