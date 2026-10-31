// Daily Problem 12th October

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        final long MOD=1000000007;
        int[] cnt=new int[30];
        for(int i:nums)
        {
            for(int j=0;j<30;j++)
            {
                cnt[j]+=i>>j&1;
            }
        }
        long total=0;
        for(int i=0;i<k;i++)
        {
            long val=0;
            for(int j=0;j<30;j++)
            {
                if(cnt[j]>i)
                {
                    val|=1L<<j;
                }
            }
            total=(total+val*val)%MOD;
        }
        return (int)total;
    }
}