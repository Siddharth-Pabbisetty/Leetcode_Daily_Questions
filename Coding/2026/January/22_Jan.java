// Daily Problem 22nd January

class Solution {
    public int minimumPairRemoval(final int[] nums) {
        int n=nums.length,cnt=0;
        while(n>1)
        {
            int mini=Integer.MAX_VALUE,minIdx=-1;
            boolean dec=true;

            for(int i=1;i<n;++i)
            {
                if(nums[i-1]+nums[i] < mini)
                {
                    mini=nums[i-1]+nums[i];
                    minIdx=i-1;
                }
                if(nums[i-1] > nums[i])
                    dec=false;
            }
            if(dec)
                return cnt;
            nums[minIdx]=mini;
            for(int i=minIdx+1;i<n-1;++i)
                nums[i]=nums[i+1];
            cnt++;
            n--;
        }
        return cnt;
    }
}