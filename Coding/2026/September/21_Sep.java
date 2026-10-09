// Daily Problem 21st September

class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] res=new long[k];
        int[] freq=new int[k];
        for(int i:nums)
        {
            i%=k;
            int[] curr=new int[k];
            curr[i]=1;
            for(int j=0;j<k;j++)
            {
                curr[j*i%k]+=freq[j];
            }
            freq=curr;
            for(int j=0;j<k;j++)
            {
                res[j]+=freq[j];
            }
        }
        return res;
    }
}