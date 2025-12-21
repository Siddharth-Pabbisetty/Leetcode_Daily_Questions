// Daily Problem 9th December

class Solution {
    public int specialTriplets(int[] nums) {
        int MOD=1000000007;
        int maxi=100000;
        long ans=0;
        int[] r = new int[maxi+1];
        int[] l = new int [maxi+1];
        for(int i:nums)
        {
            r[i]++;
        }
        for(int i=0;i<nums.length;i++)
        {
            int mid=nums[i];
            long target=(long) mid*2;
            r[mid]--;
            if(target<=maxi)
            {
                ans=(ans+((long) l[(int)target]*r[(int)target])%MOD)%MOD;
            }
            l[mid]++;
        }
        return (int)ans;
    }
}
