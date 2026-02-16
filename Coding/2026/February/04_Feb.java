// Daily Problem 4th February

class Solution {
    public long maxSumTrionic(int[] nums) {
        int n=nums.length;
        long res=-1*(long)1e16;
        for(int i=1;i<n-2;i++)
        {
            int var1=i;
            int var2=i;
            long net=nums[var1];
            while(var2+1<n && nums[var2+1]<nums[var2])
            {
                net+=(long)nums[var2+1];
                var2++;
            }
            if(var2==var1)
                continue;
            int temp=var1;
            long l=0;
            long r=0;
            long lx=Integer.MIN_VALUE;
            long rx=Integer.MIN_VALUE;
            while(var1-1>=0 && nums[var1-1]<nums[var1])
            {
                l+=(long)nums[var1-1];
                lx=Math.max(lx,l);
                var1--;
            }
            if(var1==i)
                continue;
            while(var2+1<n && nums[var2+1]>nums[var2])
            {
                r+=(long)nums[var2+1];
                rx=Math.max(rx,r);
                var2++;
            }
            if(var2==temp)
                continue;
            i=var2-1;
            res=Math.max(res,lx+rx+net);
        }
        return res;
    }
}