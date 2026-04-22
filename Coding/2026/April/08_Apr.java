// Daily Problem 8th April

class Solution {
    int MOD=1000000007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for(int[] i:queries)
        {
            int l=i[0];
            int r=i[1];
            int k=i[2];
            int v=i[3];
            int idx=l;
            while(idx<=r)
            {
                long temp=nums[idx];
                nums[idx]=(int)((temp*v)%MOD);
                idx+=k;
            }
        }
        int ans=0;
        for(int i:nums)
        {
            ans^=i;
        }
        return ans;
    }
}